layui.use(['layer','jquery'], function(){
    var layer = layui.layer;
    var $=layui.jquery;

    var userNameIf=false;

    var telIf=false;


    var pwdIf=false;


    var registerIf=false;

    //验证用户的唯一性
    $("#username").blur(function () {
        var userName=$('#username').val();
        if (/^[\u4e00-\u9fa5]+$/.test(userName)) {
            layer.msg("账户不能输入汉字！");
        }else {
            $.ajax({
                url: "/member/getTotalByPramas",
                data: {"userName": userName},
                async: false,  //允许外部变量取到ajax异步加载的数据
                type: "post",
                error: function (data) {
                    layer.msg("服务器异常");
                },
                success: function (data) {
                    console.log(data)
                    //var result = JSON.parse(data)   将json字符串转化为json对象,layui会自动将前台传过来的json字符串转化为json对象
                    //@ResponseBody注解会将对象传到前台，格式是json字符串
                    if (data.count === 0) {
                        layer.msg("该用户名可用");
                        userNameIf = true;
                    } else {
                        layer.msg("已存在该用户名");
                    }
                }
            });
        }
    })


    /* ----------- 验证输入的联系电话是否合法 --------------------- */
    $("#tel").blur(function () {
        var tel=$('#tel').val();
        if (isNaN(tel)) {
            layer.msg("联系电话不合法！");
        }else {
            $.ajax({
                url: "/member/getTotalByPramas",
                data: {"tel": tel},
                async: false,  //允许外部变量取到ajax异步加载的数据
                type: "post",
                error: function (data) {
                    layer.msg("服务器异常");
                },
                success: function (data) {
                    console.log(data)
                    //var result = JSON.parse(data)   将json字符串转化为json对象,layui会自动将前台传过来的json字符串转化为json对象
                    //@ResponseBody注解会将对象传到前台，格式是json字符串
                    if (data.count === 0) {
                        layer.msg("该手机号可用");
                        telIf = true;
                    } else {
                        layer.msg("该手机号已被注册");
                    }
                }
            });
        }
    })


    /* ----------- 验证两次输入的密码是否一致 --------------------- */

    $("#pwd2").blur(function () {
        var pwd = $("#pwd").val();
        var pwd2 = $("#pwd2").val();
        if (pwd != pwd2) {
            layer.msg("密码前后不一致");
        } else {
            pwdIf = true;
        }
    });


    $("#member-registration").submit(function () {
        if (userNameIf && telIf && pwdIf&&!registerIf) {
            var result={};
            result['userName']=$('#username').val();
            result['trueName']==$('#trueName').val();
            result['pwd']=$('#pwd').val();
            result['tel']=$('#tel').val();
            result['email']=$('#email').val();
            console.log(result)
            //ajax注册
            $.ajax({
                url:"/member/saveT",
                type:"post",
                async:false,
                data:result,
                error:function (data) {
                    layer.msg("服务器异常");
                },
                success:function (data) {
                    console.log(data);
                    if (data.code===0) {
                        registerIf=true;
                        layer.msg("注册成功");
                        setTimeout(window.location="/model/toLogin",20000);
                    }else {
                        layer.msg("注册失败");
                    }
                }
            })
        }else if (registerIf === true) {
            layer.msg("正在注册请勿重复点击");

        }else if (userNameIf === false) {
            layer.msg("用户名有误");

        }else if (telIf === false) {
        layer.msg("手机号有误");

        }else if (pwdIf === false) {
        layer.msg("两次密码不一致");

        }
        return false;//始终不跳转，利用ajax不跳转注册
    })


});



