layui.use(['layer','jquery'], function(){
    var layer = layui.layer;
    var $=layui.jquery;
    //加载订单信息
    loadOrderInfo();
    /***********************************************/

    //加载订单信息
    function loadOrderInfo() {
        $.ajax({
            url:"/order/selectOrderInfo",
            type:"post",
            async:false,
            error:function () {
                layer.msg("服务器异常");
            },
            success:function (result) {
                if (result.code === 0) {
                    var str="";
                    //console.log(result.data.length)
                    //console.log(result.data[0].detailList.length)
                    for (var i = 0; i < result.data.length; i++) {
                        for (var j = 0; j < result.data[i].detailList.length;j++){
                            str+="                                      <tr>"+
                                "                                            <td class=\"text-center image\" width=\"10%\">"+result.data[i].detailList[j].orderId+"</td>\n" +
                                "                                            <td class=\"text-center name\">"+result.data[i].detailList[j].goodName+"</td>\n" +
                                "                                            <td class=\"text-center quantity\">"+result.data[i].detailList[j].number+"件</td>\n" +
                                "                                            <td class=\"text-center quantity\">"+result.data[i].detailList[j].price+"元</td>\n" +
                                "                                            <td class=\"text-center quantity\">"+result.data[i].detailList[j].number*result.data[i].detailList[j].price+"元</td>\n" +
                                "                                            <td class=\"text-center quantity\">"+result.data[i].recevieName+"</td>\n" +
                                "                                            <td class=\"text-center quantity\">"+result.data[i].tel+"</td>\n" +
                                "                                            <td class=\"text-center quantity\">"+result.data[i].orderDate+"</td>\n" +
                                "                                        </tr>";
                        }
                    }
                    $("#orderInfo").html(str);
                }
            }
        })
    }

});



