layui.use(['layer','jquery'], function(){
    var layer = layui.layer;
    var $=layui.jquery;

    var goodsId=$("#goodsId").val();
    //根据商品id加载商品详细信息
    loadGoodDetail(goodsId);
    //购物车按钮绑定事件
    addCar(goodsId);
    /***********************************************/
    //根据商品id加载商品详细信息
    function loadGoodDetail(goodsId) {
        $.ajax({
            url:"/goods/loadObjectByPramas",
            async:false,
            data:{"goodsId":goodsId},
            type:"post",
            error:function () {
                layer.msg("服务器异常");
            },
            success:function (result) {
                if (result.code === 0) {
                    var str="";
                    if (result.data!= null) {
                            str+=" <div class=\"row\">\n" +
                                "                                    <div class=\"col-xs-12 col-md-4 col-sm-4\">\n" +
                                "                                        <ul class=\"thumbnails\" style=\"list-style: none\">\n" +
                                "                                            <li><a class=\"thumbnail\" href=\"#\"> <img src=\""+result.data.picture+"\"></a></li>\n" +
                                "                                        </ul>\n" +
                                "                                    </div>\n" +
                                "                                    <div class=\"col-xs-12 col-md-8 col-sm-8\">\n" +
                                "                                        <div style=\"margin-left: 30px; margin-top: 20px\">\n" +
                                "                                            <h1 class=\"product-title\">"+result.data.goodName+"</h1>\n" +
                                "                                            <ul class=\"list-unstyled price\"><li><h2>"+result.data.nowPrice+"元</h2></li></ul>\n" +
                                "                                            <ul class=\"list-unstyled price\"><li>原价:"+result.data.price+"元</li></ul>\n" +
                                "                                            <div class=\"rating\"><p>商城活动：全场满99包邮</p></div>\n" +
                                "                                            <div id=\"product\"><hr>\n" +
                                "                                                <div class=\"form-group\">\n" +
                                "                                                    <label class=\"control-label\" for=\"shuliang\"> 数量 </label>\n" +
                                "                                                    <input type=\"number\" name=\"quantity\" value=\"1\" size=\"2\"\n" +
                                "                                                           id=\"count\" class=\"form-control\"> <br>\n" +
                                "                                                    <div class=\"btn-group\">\n" +
                                "                                                        <button type=\"button\"  class=\"btn btn-primary btn-primary\">\n" +
                                "                                                            <i class=\"fa fa-shopping-cart\"></i> 添加到购物车</button>\n" +
                                "                                                        <button type=\"button\" id=\"button-wishlist\" data-toggle=\"tooltip\" class=\"btn\"\n" +
                                "                                                                title=\"收藏\" data-original-title=\"收藏\"> <i class=\"fa fa-heart\"></i></button>\n" +
                                "                                                    </div>\n" +
                                "                                                </div>\n" +
                                "                                            </div>\n" +
                                "                                        </div>\n" +
                                "                                    </div>\n" +
                                "                                    <div class=\"col-sm-12 description_oc clearfix\">\n" +
                                "                                        <ul class=\"nav nav-tabs htabs\">\n" +
                                "                                            <li class=\"active\" style=\"width: 150px\"><a href=\"#tab-description\" data-toggle=\"tab\"\n" +
                                "                                                                                       aria-expanded=\"true\">商品描述</a></li>\n" +
                                "                                        </ul>\n" +
                                "                                        <div class=\"tab-content\" style=\"border: 1px solid #eee; overflow: hidden;\">\n" +
                                "                                            <div class=\"tab-pane active\" id=\"tab-description\">"+result.data.introduce+"</div>\n" +
                                "                                        </div>\n" +
                                "                                    </div>\n" +
                                "                                </div>";

                        $("#content_oc").html(str);
                        $("#typeId").val(result.data.typeId);
                    }else {
                        layer.msg("您的操作有误");
                        setTimeout(function () {
                            window.location.href="/model/toIndex";
                        },2000);
                    }

                }
            }
        })

    }


    //为加入购物车按钮绑定事件
    function addCar(goodsId) {
        //为加入购物车按钮绑定事件
        $(".btn-group>button:eq(0)").click(function () {
            var count=$("#count").val();
            //将商品添加到购物车
            $.ajax({
                url: "/goods/addGoodToCar",
                async: false,
                type: "post",
                data:{"goodsId":goodsId,"count":count},
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



