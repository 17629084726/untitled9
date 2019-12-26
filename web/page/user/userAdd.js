layui.use(['form','layer',"jquery",'upload'],function(){
    var form = layui.form,
    upload = layui.upload,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;
    form.render();
    form.on("submit(addUser)",function(data){
        //弹出loading
        console.log(data);
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.5});
        setTimeout(function(){
            $.ajax(
                {
                    url: "/ren/addUser.action",
                    data: JSON.stringify(data.field),
                    dataType: "json",
                    type: "post",
                    contentType: "application/json",
                    success: function (d) {
                        // d.msg == "success"
                        if (d>0) {
                            reid = d;
                            // $("#uploadImg").trigger("click");
                            // layer.msg("添加成功！")
                            top.layer.close(index);
                            top.layer.msg("用户添加成功！");
                            top.layer.closeAll();
                            // layer.close(layer.index)
                            //刷新父页面
                            parent.location.reload();
                           // location.href="/ren/tableuser.action"
                        } else {
                            layer.msg("添加失败")
                        }
                    }
                }
            )
        },2000);
        return false;
    })

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

})