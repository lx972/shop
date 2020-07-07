layui.use(['layer','jquery'], function(){
    var layer = layui.layer;
    var $=layui.jquery;

    var superType=$("#superType").val();
    var page=1;
    //页数
    var pages=0;
    var limit=2;
    //加载查询结果
    loadSearchResult(superType,page,limit);
    //加入购物车
    addCar();
    //首页
    $("tr>td>a:eq(0)").click(function () {
        page=1;
        loadSearchResult(superType,page,limit);
    })

    //上一页
    $("tr>td>a:eq(1)").click(function () {
        if(page>1){
            page=page-1;
        }else {
            page=1;
        }
        loadSearchResult(superType,page,limit);
    })

    //下一页
    $("tr>td>a:eq(2)").click(function () {
        if(page<pages){
            page=page+1;
        }else {
            page=pages;
        }
        loadSearchResult(superType,page,limit);
    })

    //尾页
    $("tr>td>a:eq(3)").click(function () {
        page=pages;
        loadSearchResult(superType,page,limit);
    })

    /***********************************************/

    //加载查询结果
    function loadSearchResult(superType,page,limit) {
     $.ajax({
         url:"/goods/getAllGoodsByOne",
         data:{"superType":superType,"page":page,"limit":limit},
         async:false,
         type:"post",
         error:function () {
             layer.msg("服务器异常");
         },
         success:function (result) {
             console.log(result);
             pages=result.pages;
             if (result.code === 0) {
                 var str="";
                 for (var i = 0; i < result.data.length; i++) {
                     str += "<div class=\"product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12\">\n" +
                         "                                                <div class=\"product-thumb\">\n" +
                         "                                                    <div class=\"actions\">\n" +
                         "                                                        <div class=\"image\">\n" +
                         "                                                            <a href=\"/model/toGoodDetail?goodsId=" + result.data[i].goodsId+"\">\n" +
                         "                                                                <img src=\""+result.data[i].picture+"\" class=\"img-responsive\">\n" +
                         "                                                            </a>\n" +
                         "                                                        </div>\n" +
                         "                                                        <div class=\"button-group btn-grid\">\n" +
                         "                                                            <div class=\"cart\">\n" +
                         "                                                                <button class=\"btn btn-primary btn-primary\"\n" +
                         "                                                                        value=\""+result.data[i].goodsId+"\""+
                         "                                                                        type=\"button\" data-toggle=\"tooltip\"\n" +
                         "                                                                        style=\"display: none; width: 33.3333%;\"\n" +
                         "                                                                        data-original-title=\"添加到购物车\">\n" +
                         "                                                                    <i class=\"fa fa-shopping-cart\"></i>\n" +
                         "                                                                </button>\n" +
                         "                                                            </div>\n" +
                         "                                                            <div class=\"wishlist\">\n" +
                         "                                                                <button class=\"btn\" type=\"button\" data-toggle=\"tooltip\"\n" +
                         "                                                                        title=\"收藏\">\n" +
                         "                                                                    <i class=\"fa fa-heart\"></i>\n" +
                         "                                                                </button>\n" +
                         "                                                            </div>\n" +
                         "                                                        </div>\n" +
                         "                                                    </div>\n" +
                         "                                                    <div>\n" +
                         "                                                        <div class=\"caption\">\n" +
                         "                                                            <div class=\"name\">\n" +
                         "                                                                <a href=\"/model/toGoodDetail?goodsId="+result.data[i].goodsId+"\" style=\"width: 95%\">\n" +
                         "                                                                    <span style=\"color: #0885B1\">商品名称：</span>"+result.data[i].goodName+"</a>\n" +
                         "                                                            </div>\n" +
                         "                                                            <p class=\"price\">\n" +
                         "                                                                <span class=\"price-new\">分类：</span> <span>"+result.data[i].typeName+"</span>\n" +
                         "                                                                <span class=\"price-tax\">价格: "+result.data[i].nowPrice+"元</span>\n" +
                         "                                                            </p>\n" +
                         "                                                        </div>\n" +
                         "                                                    </div>\n" +
                         "                                                </div>\n" +
                         "                                            </div>";
                 }
                 $("#result_info").html(str);
                 $("tr>td>span").html("当前页数："+page)
                 //$(".mrshop_heading_h1").html(result.data[0].typeName);
             }
         }
     })
    }

    //为加入购物车按钮绑定事件
    function addCar() {
        //为加入购物车按钮绑定事件
        $(".cart").find("button").on("click",function () {
            var goodsId=$(this).val();
            //将商品添加到购物车
            $.ajax({
                url: "/goods/addGoodToCar",
                async: false,
                type: "post",
                data:{"goodsId":goodsId},
                error: function () {
                    layer.msg("服务器异常");
                },
                success: function (result) {
                    if (result.msg === "unlogin") {
                        console.log(result);
                        layer.msg("用户未登录，请先登录");
                        setTimeout(function () {
                            window.location.href="/model/toLogin"
                        },2000);
                    }else if (result.code === 0) {
                        console.log(result);
                        layer.msg("加入购物车成功");
                        setTimeout(function () {
                            window.location.href="/model/toGoodCar"
                        },2000);
                    }
                }
            });
        })
    }

});



