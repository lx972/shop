package cn.kgc.shop.controller;

import cn.kgc.shop.model.MemberEntity;
import cn.kgc.shop.service.GoodsService;
import cn.kgc.shop.utils.Good;
import cn.kgc.shop.utils.GoodCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import cn.kgc.shop.model.GoodsEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author lx
 *   Goods控制器
 * @date 2020-06-28 16:19:19
 */
@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController<GoodsEntity>{

	@Autowired
	private GoodsService goodsService;

	/**
	 * 注入redis操作对象
	 */
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 查询热门商品信息
	 */
	@RequestMapping("/getHitGoods")
	@ResponseBody
	public Map<String,Object> getHitGoods(){
		try {
			List<GoodsEntity> hitGoods = goodsService.getHitGoods();
			return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,hitGoods);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}



	/**
	 * 查询前12条最新商品信息
	 */
	@RequestMapping("/getNewGoods")
	@ResponseBody
	public Map<String,Object> getNewGoods(){
		try {
			List<GoodsEntity> hitGoods = goodsService.getNewGoods();
			return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,hitGoods);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}


	/**
	 * 查询前12条最新打折商品信息
	 */
	@RequestMapping("/getSaleGoods")
	@ResponseBody
	public Map<String,Object> getSaleGoods(){
		try {
			List<GoodsEntity> hitGoods = goodsService.getSaleGoods();
			return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,hitGoods);
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}


	/**
	 * 添加商品到购物车
	 */
	@RequestMapping("/addGoodToCar")
	@ResponseBody
	public Map<String,Object> addGoodToCar(GoodsEntity goodsEntity, @RequestParam(defaultValue = "1") Integer count, HttpSession session){
		try {
			//首先判断是否登录
			MemberEntity loginUser = (MemberEntity) session.getAttribute("loginUser");
			if (null == loginUser) {
				//未登录
				return putMsgToJsonString(FAILCODE,"unlogin",FAILCOUNT,null);
			}else {
				//已登录
				GoodCar goodCar=null;
				List<Good> list=null;
				//查询该商品信息
				GoodsEntity objectByPramas = baseService.findObjectByPramas(goodsEntity);
				//得到redis操作字符串对象
				ValueOperations vo = redisTemplate.opsForValue();
				if (!redisTemplate.hasKey(loginUser.getMemberId() + "_" + loginUser.getUserName())){
					//没有购物车,创建一个
					goodCar=new GoodCar();
					list=new ArrayList<>();
					Good good=new Good();
					good.setCount(count);
					good.setGoodName(objectByPramas.getGoodName());
					good.setGoodsId(objectByPramas.getGoodsId());
					good.setPicture(objectByPramas.getPicture());
					good.setNowPrice(objectByPramas.getNowPrice());
					list.add(good);

				}else {
					//该用户有购物车
					//从redis中取出购物车对象
					goodCar = (GoodCar) vo.get(loginUser.getMemberId() + "_" + loginUser.getUserName());
					list = goodCar.getCars();
					Good good=null;
					for (Good good1 : list) {
						if (objectByPramas.getGoodsId().equals(good1.getGoodsId())){
							good=good1;
							break;
						}
					}
					if (good == null) {
						//购物车中没有该商品
						good=new Good();
						good.setCount(count);
						good.setGoodName(objectByPramas.getGoodName());
						good.setGoodsId(objectByPramas.getGoodsId());
						good.setPicture(objectByPramas.getPicture());
						good.setNowPrice(objectByPramas.getNowPrice());
						list.add(good);

					}else {
						//购物车中有该商品
						//删除原来的商品
						list.remove(good);
						//商品数量加一
						good.setCount(good.getCount()+count);
						//加到购物车中
						list.add(good);
					}
				}
				goodCar.setCars(list);
				//将购物车对象保存到redis中
				vo.set(loginUser.getMemberId() + "_" + loginUser.getUserName(),goodCar);
				return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}



	/**
	 * 查询购物车中的商品
	 */
	@RequestMapping("/findGoodCar")
	@ResponseBody
	public Map<String,Object> findGoodCar(HttpSession session){
		try {
			//首先取出登录用户
			MemberEntity loginUser = (MemberEntity) session.getAttribute("loginUser");
			if (redisTemplate.hasKey(loginUser.getMemberId() + "_" + loginUser.getUserName())){
				//存在购物车对象
				//得到redis操作字符串的对象
				ValueOperations vo = redisTemplate.opsForValue();
				GoodCar o = (GoodCar) vo.get(loginUser.getMemberId() + "_" + loginUser.getUserName());
				return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,o.getCars());
			}
			return putMsgToJsonString(SUCCESSCODE,FAIL,FAILCOUNT,null);
		}catch (Exception e){
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}



	/**
	 * 清空购物车中的商品
	 */
	@RequestMapping("/clearCar")
	@ResponseBody
	public Map<String,Object> clearCar(HttpSession session){
		try {
			//首先取出登录用户
			MemberEntity loginUser = (MemberEntity) session.getAttribute("loginUser");
			if (redisTemplate.hasKey(loginUser.getMemberId() + "_" + loginUser.getUserName())){
				//存在购物车对象

				redisTemplate.delete(loginUser.getMemberId() + "_" + loginUser.getUserName());

			}
			return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,null);
		}catch (Exception e){
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}


	/**
	 * 查询分类后的热门商品信息
	 */
	@RequestMapping("/getLeftHotGoods")
	@ResponseBody
	public Map<String,Object> getLeftHotGoods(Integer superType){
		try {
			List<GoodsEntity> leftHotGoods = goodsService.getLeftHotGoods(superType);
			return putMsgToJsonString(SUCCESSCODE,SUCCESS,FAILCOUNT,leftHotGoods);
		}catch (Exception e){
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}



	/**
	 * 商品名模糊查询
	 */
	@RequestMapping("/getGoodByGoodName")
	@ResponseBody
	public Map<String,Object> getGoodByGoodName(Integer page,Integer limit,String goodName){
		try {
			map = goodsService.getGoodByGoodName(page, limit, goodName);
			map.put("code",SUCCESSCODE);
			map.put("msg",SUCCESS);
			return map;
		}catch (Exception e){
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}


	/**
	 * 查询分类后全部商品信息
	 */
	@RequestMapping("/getAllGoodsByOne")
	@ResponseBody
	public Map<String,Object> getAllGoodsByOne(Integer page,Integer limit,Integer superType){
		try {
			map = goodsService.getAllGoodsByOne(page,limit,superType);
			map.put("code",SUCCESSCODE);
			map.put("msg",SUCCESS);
			return map;
		}catch (Exception e){
			e.printStackTrace();
			return putMsgToJsonString(FAILCODE,ERROR,FAILCOUNT,null);
		}
	}

}
