layui.use(['layer','jquery'], function(){
    var layer = layui.layer;
    var $=layui.jquery;

    //加载购物车中的商品
    loadGoodCar();

    //清空购物车中的商品
    $("#clearCar").on("click",function () {
        //清空购物车中的商品
        clearCar();
        //重新加载购物车
        loadGoodCar();
    });

    //实现一个支付对话框
    $("#pay").on("click",function () {
        if ($("#sum").html()=="0元") {
            //购物车中没有商品
            layer.msg("您还没有购物");
        }else {
            //购物车中有商品，支付
            pay();
        }


    })



    /***********************************************/
    //加载购物车中的商品
    function loadGoodCar() {
        $.ajax({
            url:"/goods/findGoodCar",
            type:"post",
            async:false,
            error:function () {
                layer.msg("服务器异常");
            },
            success:function (result) {
                var str="";
                //总金额
                var sum=0;
                if (result.msg === "success") {
                    //购物车存在

                    for (var i=0;i<result.data.length;i++){
                        str+="<tr>\n" +
                            "                                            <td class=\"text-center image\" width=\"20%\">\n" +
                            "                                                <a href=\"/model/toGoodDetail?goodsId="+result.data[i].goodsId+"\">\n" +
                            "                                                    <img width=\"80px\" src=\""+result.data[i].picture+"\">\n" +
                            "                                                </a>\n" +
                            "                                            </td>\n" +
                            "                                            <td class=\"text-left name\">\n" +
                            "                                                <a href=\"/model/toGoodDetail?goodsId="+result.data[i].goodsId+"\">"+result.data[i].goodName+"</a>\n" +
                            "                                            </td>\n" +
                            "                                            <td class=\"text-left quantity\">"+result.data[i].count+"件</td>\n" +
                            "                                            <td class=\"text-right price\">"+result.data[i].nowPrice+"元</td>\n" +
                            "                                            <td class=\"text-right total\">"+(result.data[i].count*result.data[i].nowPrice)+"元</td>\n" +
                            "                                        </tr>";
                        sum+=result.data[i].count*result.data[i].nowPrice;
                    }


                }else {
                    str+="<tr rowspan=\"2\" >\n" +
                        "                                                <td colspan=\"5\" style=\"text-align: center;\">您的购物车为空！</td>\n" +
                        "                                            </tr>"
                }
                $("#goodInfo").html(str);
                $("#sum").html(sum+"元")
            }
        })
    }


    //清空购物车中的商品
    function clearCar() {
        $.ajax({
            url:"/goods/clearCar",
            type:"post",
            async:false,
            error:function () {
                layer.msg("服务器异常");
            },
            success:function (result) {
                if (result.code === 0) {
                    layer.msg("清空购物车成功");
                }
            }
        });
    }



    //实现一个支付对话框
    function pay() {
        //验证收货人姓名
        if ($('#recevieName').val() === "") {
            alert('收货人姓名不能为空！');
            return;
        }
        //验证收货人手机
        if ($('#tel').val() === "") {
            alert('收货人手机不能为空！');
            return;
        }
        //验证手机号是否合法
        if (isNaN($('#tel').val())) {
            alert("手机号请输入数字");
            return;
        }
        //验证收货人地址
        if ($('#address').val() === "") {
            alert('收货人地址不能为空！');
            return;
        }
        //设置对话框中要显示的内容
        var html = '<div class="popup_cont">'
            + '<p>扫一扫支付</p>'
            + '<strong>￥<font id="show_money_info">0.01元</font></strong>'
            + '<div style="width: 256px; height: 250px; text-align: center; margin-left: auto; margin-right: auto;" >'
            + '<image src="/static/front/images/qr.png" width="256" height="256" /></div>'
            + '</div><p style="text-align:center">支付二维码仅为测试用（相关知识点在书中有介绍）</p>';


        layer.open({
            title: "支付"
            ,content: html
            ,area: ['400px', '500px']
            ,closeBtn: 2
            , yes: function(index, layero){
                //do something
                //提交表单
                $("#myform").submit();
                layer.close(index); //如果设定了yes回调，需进行手工关闭
            }
        });

    }


    //提交表单事件
    $("#myform").submit(function () {
        $.ajax({
            url: "/order/addGoodOrder",
            async: false,
            type: "post",
            data:$("#myform").serialize(),
            error: function () {
                layer.msg("服务器异常");
            },
            success: function (result) {
                if (result.code === 0) {
                    layer.msg("生成订单成功");
                    setTimeout(function () {
                        window.location.href="/model/toOrder"
                    },2000);
                }
            }
        });
        return false;
    })

});



