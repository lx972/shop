layui.use(['layer','jquery'], function(){
    var layer = layui.layer;
    var $=layui.jquery;

    //调用jquery幻灯片插件轮播广告
    $("#slidershow").nivoSlider();



    //查询热门商品信息
    getHitGoods();
    //查询最新上架的商品信息
    getNewGoods();
    //查查询前12条最新打折商品信息
    getSaleGoods();
    //为加入购物车按钮绑定事件
    addCar();
    /***********************************************/
    //查询热门商品信息
    function getHitGoods() {
        $.ajax({
            url:"/goods/getHitGoods",
            async:false,
            type:"post",
            error:function () {
                layer.msg("服务器异常");
            },
            success:function (result) {
                if (result.code === 0) {
                    //查到了
                    console.log(result.data);
                    var str='';
                    for (var i = 0; i < result.data.length; i++) {
                        str+=" <div class=\"box-product product-grid\">\n" +
                            "<div>" +
                            "<div class=\"image\">\n" +
                            "<a href=\"/model/toGoodDetail?goodsId="+result.data[i].goodsId+"\">\n" +
                            "<img src=\""+result.data[i].picture+"\" width=\"250px\">\n" +
                            "</a>\n" +
                            "</div>\n" +
                            "<div class=\"name\">\n" +
                            "<a href=\"/model/toGoodDetail?goodsId="+result.data[i].goodsId+"\">\n" +result.data[1].goodName+
                            "                                                    </a>\n" +
                            "                                                </div>\n" +
                            "                                                <div class=\"rating\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"fa fa-stack\"><i\n" +
                            "                                                            class=\"fa fa-star fa-stack-2x\"></i><i\n" +
                            "                                                            class=\"fa fa-star-o fa-stack-2x\"></i> </span> <span\n" +
                            "                                                        class=\"fa fa-stack\"><i\n" +
                            "                                                        class=\"fa fa-star fa-stack-2x\"></i><i\n" +
                            "                                                        class=\"fa fa-star-o fa-stack-2x\"></i> </span> <span\n" +
                            "                                                        class=\"fa fa-stack\"><i\n" +
                            "                                                        class=\"fa fa-star fa-stack-2x\"></i><i\n" +
                            "                                                        class=\"fa fa-star-o fa-stack-2x\"></i> </span> <span\n" +
                            "                                                        class=\"fa fa-stack\"><i\n" +
                            "                                                        class=\"fa fa-star fa-stack-2x\"></i><i\n" +
                            "                                                        class=\"fa fa-star-o fa-stack-2x\"></i> </span> <span\n" +
                            "                                                        class=\"fa fa-stack\"><i\n" +
                            "                                                        class=\"fa fa-star fa-stack-2x\"></i><i\n" +
                            "                                                        class=\"fa fa-star-o fa-stack-2x\"></i> </span>\n" +
                            "                                                </div>\n" +
                            "                                                <div class=\"price\">\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"price-new\">"+"价格："+result.data[i].price+"元"+"</span>\n" +
                            "                                                </div>\n" +
                            "                                            </div>\n" +
                            "                                        </div>";
                    }
                    $("#hitGoods").html(str);
                }
            }
        })
    }


    //查询最新上架的商品信息
    function getNewGoods() {
        $.ajax({
            url:"/goods/getNewGoods",
            async:false,
            type:"post",
            error:function () {
                layer.msg("服务器异常");
            },
            success:function (result) {
                if (result.code === 0) {
                    //查到了
                    console.log(result.data);
                    var str='';
                    for (var i = 0; i < result.data.length; i++) {
                        str+="<div class=\"product-grid col-lg-2 col-md-3 col-sm-6 col-xs-12\">\n" +
                            "                                                <div class=\"product-thumb transition\">\n" +
                            "                                                    <div class=\"actions\">\n" +
                            "                                                        <div class=\"image\">\n" +
                            "                                                            <a href=\"/model/toGoodDetail?goodsId="+result.data[i].goodsId+"\"> \n" +
                            "                                                                <img src=\""+result.data[i].picture+"\" alt=\""+result.data[i].goodName+"\" class=\"img-responsive\"></a>\n" +
                            "                                                        </div>\n" +
                            "                                                        <div class=\"button-group\">\n" +
                            "                                                            <div class=\"cart\">\n" +
                            "                                                                <button class=\"btn btn-primary btn-primary\" type=\"button\"\n" +
                            "                                                                   value=\""+result.data[i].goodsId+"\""+
                            "                                                                        data-toggle=\"tooltip\"\n" +
                            "                                                                        style=\"display: none; width: 33.3333%;\"\n" +
                            "                                                                        data-original-title=\"加入到购物车\">\n" +
                            "                                                                    <i class=\"fa fa-shopping-cart\"></i>\n" +
                            "                                                                </button>\n" +
                            "                                                            </div>\n" +
                            "                                                        </div>\n" +
                            "                                                    </div>\n" +
                            "                                                    <div class=\"caption\">\n" +
                            "                                                        <div class=\"name\" style=\"height: 40px\">\n" +
                            "                                                            <a href=\"/model/toGoodDetail?goodsId="+result.data[i].goodsId+"<span style=\"color: #0885B1\">商品名：</span>"+result.data[i].goodName+"</a>\n" +
                            "                                                        </div>\n" +
                            "                                                        <p class=\"price\">价格："+result.data[i].nowPrice+"元</p>\n" +
                            "                                                    </div>\n" +
                            "                                                </div>\n" +
                            "                                            </div>"
                    }
                    $("#newGoods").html(str);


                }
            }
        })

    }


    //查查询前12条最新打折商品信息
    function getSaleGoods() {
        $.ajax({
            url:"/goods/getSaleGoods",
            async:false,
            type:"post",
            error:function () {
                layer.msg("服务器异常");
            },
            success:function (result) {
                if (result.code === 0) {
                    //查到了
                    console.log(result.data);
                    var str="";
                    for (var i = 0; i < result.data.length; i++) {
                        str+="<div class=\"product-grid col-lg-2 col-md-3 col-sm-6 col-xs-12\">\n" +
                            "                                            <div class=\"product-thumb transition\">\n" +
                            "                                                <div class=\"actions\">\n" +
                            "                                                    <div class=\"image\">\n" +
                            "                                                        <a href=\"/model/toGoodDetail?goodsId="+result.data[i].goodsId+"\">\n" +
                            "                                                            <img src=\""+result.data[i].picture+"\" alt=\""+result.data[i].goodName+"\" class=\"img-responsive\"> </a>\n" +
                            "                                                    </div>\n" +
                            "                                                    <div class=\"button-group\">\n" +
                            "                                                        <div class=\"cart\">\n" +
                            "                                                            <button class=\"btn btn-primary btn-primary\" type=\"button\"\n" +
                            "                                                                    value=\""+result.data[i].goodsId+"\""+
                            "                                                                    data-toggle=\"tooltip\"\n" +
                            "                                                                    style=\"display: none; width: 33.3333%;\"\n" +
                            "                                                                    data-original-title=\"加入到购物车\">\n" +
                            "                                                                <i class=\"fa fa-shopping-cart\"></i>\n" +
                            "                                                            </button>\n" +
                            "                                                        </div>\n" +
                            "                                                    </div>\n" +
                            "                                                </div>\n" +
                            "                                                <div class=\"caption\">\n" +
                            "                                                    <div class=\"name\" style=\"height: 40px\">\n" +
                            "                                                        <a href=\"/model/toGoodDetail?goodsId="+result.data[i].goodsId+"\"\n" +
                            "                                                           style=\"width: 95%\"> \n" +
                            "                                                            <span style=\"color: #0885B1\">商品名：</span>"+result.data[i].goodName+"</a>\n" +
                            "                                                    </div>\n" +
                            "                                                    <div class=\"name\" style=\"margin-top: 10px\">\n" +
                            "                                                        <span style=\"color: #0885B1\">分类：</span>"+result.data[i].typeName+"\n" +
                            "                                                    </div>\n" +
                            "                                                    <span class=\"price\"> 现价："+result.data[i].nowPrice+" 元\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t</span><br> <span class=\"oldprice\">原价："+result.data[i].price+"元</span>\n" +
                            "                                                </div>\n" +
                            "                                            </div>\n" +
                            "                                        </div>";
                    }
                    $("#saleGoods").html(str);
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
                        setTimeout(window.location.href="/model/toLogin",2000);
                    }else if (result.code === 0) {
                        console.log(result);
                        layer.msg("加入购物车成功");
                        setTimeout(window.location.href="/model/toGoodCar",2000);
                    }
                }
            });
        })
    }

});



