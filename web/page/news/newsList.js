layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //列表
    var tableIns = table.render({
        elem: '#newsList',
        url : '/ren/tablequestion.action',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        id : "newsListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'paperId', title: '试题ID', width:120, align:"center"},
            {field: 'paperName', title: '试题名称', width:350},
            {field: 'userName', title: '发布者', align:'center'},
            //{field: 'questionTime', title: '发布时间', align:'center'},
            {field: 'questionTime', title: '发布时间', align:'center', minWidth:110, templet:function(d){
                return d.questionTime.substring(0,10);
            }},
            {title: '操作', width:170, templet:'#newsListBar',fixed:"right",align:"center"}
        ]]
    });

    //是否置顶
    form.on('switch(newsTop)', function(data){
        var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            layer.close(index);
            if(data.elem.checked){
                layer.msg("置顶成功！");
            }else{
                layer.msg("取消置顶成功！");
            }
        },500);
    })

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加文章
    function addNews(edit){
        var index = layui.layer.open({
            title : "添加试题",
            type : 2,
            content : "examAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".newsName").val(edit.newsName);
                    body.find(".abstract").val(edit.abstract);
                    body.find(".thumbImg").attr("src",edit.newsImg);
                    body.find("#news_content").val(edit.content);
                    body.find(".newsStatus select").val(edit.newsStatus);
                    body.find(".openness input[name='openness'][title='"+edit.newsLook+"']").prop("checked","checked");
                    body.find(".newsTop input[name='newsTop']").prop("checked",edit.newsTop);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回试题列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }
    $(".addNews_btn").click(function(){
        addNews();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('newsListTable'),
            data = checkStatus.data,
            paperId = [];
        if(data.length > 0) {
            for (var i in data) {
                paperId.push(data[i].paperId);
            }
            layer.confirm('确定删除选中的文章？', {icon: 3, title: '提示信息'}, function (index) {
                $.ajax(
                    {
                        url: "/ren/deleteQuestionAll.action",
                        data: {id:paperId},
                        dataType: "json",
                        type: "get",
                        contentType: false,   //jax 中 contentType 设置为 false 是为了避免 JQuery 对其操作，从而失去分界符，而使服务器不能正常解析文件
                        processData: false,
                        success: function (d) {
                            // d.msg == "success"
                            if (d>0) {
                                reid = d;
                                // $("#uploadImg").trigger("click");
                                // layer.msg("添加成功！")
                                layer.close(index);
                                layer.msg("删除成功！");
                                layer.closeAll();
                                // layer.close(layer.index)
                                //刷新父页面
                                parent.location.reload();
                                // location.href="/ren/tableuser.action"
                            } else {
                                layer.msg("删除失败")
                            }
                        }
                    }
                )
                //  $.get("/ren/deleteQuestionAll.action",{
                //      paperId : paperId  //将需要删除的newsId作为参数传入
                //  },function(data){
                // tableIns.reload();
                // layer.close(index);
                //  })
            })
        }else{
            layer.msg("请选择需要删除的文章");
        }
    })

    //列表操作
    table.on('tool(newsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
       // alert(data.paperId);
        var id=data.paperId;
       if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此试题？',{icon:3, title:'提示信息'},function(index){
                $.ajax(
                    {
                        url: "/ren/deleteQuestionByid.action",
                        data: {"id":id},
                        dataType: "json",
                        type: "get",
                        contentType: "application/json",
                        success: function (d) {
                            // d.msg == "success"
                            if (d>0) {
                                reid = d;
                                layer.close(index);
                                layer.msg("删除成功！");
                                layer.closeAll();
                                // layer.close(layer.index)
                                //刷新父页面
                                parent.location.reload();
                                // location.href="/ren/tableuser.action"
                            } else {
                                layer.msg("删除失败")
                            }
                        }
                    }
                )
                 // $.get("/ren/deleteQuestionByid.action",{
                 //     paperId : data.paperId  //将需要删除的newsId作为参数传入
                 // },function(data){
                 //    tableIns.reload();
                 //    layer.close(index);
                 // })
            });
        }
    });

})