layui.use(['layer','jquery'], function(){
    var layer = layui.layer;
    var $=layui.jquery;

    var codeIf=false;


    //刷新验证码
    $("#img_checkCode").click(function () {
        $("#img_checkCode")[0].src=($("#img_checkCode")[0].src+'?'+new Date());
    })

    //验证验证码是否输入正确
    $("#checkCode").blur(function () {
        var code=$("#checkCode").val();
        $.ajax({
            url:"/member/checkCode",
            type:"post",
            data:{"code":code},
            async:false,
            error:function () {
                layer.msg("服务器异常");
            },
            success:function (data) {
                if (data.code === 0) {
                    codeIf=true;
                    layer.msg("验证码正确")
                }else {
                    layer.msg("验证码错误")
                }
            }
        })

    })

    //表单提交
    $("#login_form").submit(function () {
        if (codeIf) {
            //验证码正确，登录
            var login_form={};
            var userName=$("#userName").val();
            var pwd=$("#pwd").val();
            login_form['userName']=userName;
            login_form['pwd']=pwd;
            $.ajax({
                url:"/member/login",
                data:login_form,
                async:false,
                type:"post",
                error:function () {
                    layer.msg("服务器异常");
                },
                success:function (data) {
                    if (data.code === 0) {
                        layer.msg("登录成功");
                        setTimeout(window.location="/model/toIndex",2000);
                    }else {
                        layer.msg("用户名或密码错误");
                    }
                }
            })
        }else {
            layer.msg("验证码未填写正确");
        }

        return false;
    })


});



