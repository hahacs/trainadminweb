let tableIns;
let tree;
layui.use(['element', 'form', 'table', 'layer', 'laydate','tree', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    tree = layui.tree;
    let height = document.documentElement.clientHeight;
    // let height = document.documentElement.clientHeight - 160;

    tableIns = table.render({
        elem: '#trainMainTable'
        , url: ctx + '/train/trainMain/page'
        , method: 'POST'
        //请求前参数处理
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'rows' //每页数据量的参数名，默认：limit
        }
        , response: {
            statusName: 'flag' //规定数据状态的字段名称，默认：code
            , statusCode: true //规定成功的状态码，默认：0
            , msgName: 'msg' //规定状态信息的字段名称，默认：msg
            , countName: 'records' //规定数据总数的字段名称，默认：count
            , dataName: 'rows' //规定数据列表的字段名称，默认：data
        }
        //响应后数据处理
        , parseData: function (res) { //res 即为原始返回的数据
            var data = res.data;
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.records, //解析数据长度
                "rows": data.rows //解析数据列表
            };
        }
        , toolbar: '#authorityTableToolbarDemo'
        , title: '用户列表'
        , cols: [[
            {field: 'id', title: 'ID', hide: true}
            , {field: 'trainTitle', title: '训练标题',width:380,align:"center"}
            , {field: 'trainType', title: '训练类型',width:100,toolbar: '#trainTypeBarDemo'}
            , {field: 'trainTimes', title: '训练次数',width:80,sort: true}
            , {field: 'trainAllTime', title: '训练总时长',width:100,sort: true, toolbar: '#trainAllTimeBarDemo'}
            , {field: 'lastTrainTime', title: '最后一次训练时间',width:160,sort: true}
            , {field: 'date_created', title: '创建时间',width:160,sort: true}
            , {fixed: 'right', title: '操作', width:110,toolbar: '#authorityTableBarDemo'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
        ,done:function (res,curr,count) {

            layui.each($("select[name='trainTypeSelect']"),function (index,item) {
                var elem = $(item);
                elem.val(elem.data('state')).parents('div.layui-table-cell').css('overflow', 'visible');;
            })
            form.render();

            // tabledata =res.data;
            //
            // $('tr').each(function (e) {
            //     var $cr = $(this);
            //     var dataindex = $cr.attr("data-index");
            //     $.each(tabledata,function (index,value) {
            //         alert(value);
            //         if(value.LAY_TABLE_INDEX == dataindex){
            //             $cr.find('td').eq(1).find('input').val(value.city);
            //         }
            //     })
            //
            // })
        }
    });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        switch (obj.event) {
            case 'addData':
                //重置操作表单
                $("#authorityForm")[0].reset();
                form.render();
                layer.msg("请填写右边的表单并保存！");
                break;
            case 'query':
                let queryByAuthorityName = $("#queryByAuthorityName").val();
                let query = {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , done: function (res, curr, count) {
                        //完成后重置where，解决下一次请求携带旧数据
                        this.where = {};
                    }
                };
                if (queryByAuthorityName) {
                    //设定异步数据接口的额外参数
                    query.where = {authorityName: queryByAuthorityName};
                }
                tableIns.reload(query);
                $("#queryByAuthorityName").val(queryByAuthorityName);
                break;
        }
    });

    //每次点击排序，原先绑定时间就失效，此处重新绑定事件
    table.on('sort(test)', function(obj){
        // table.reload(tableid, {
        // });
        //此处需重新为单元格绑定点击事件，因为layui点击排序后，表格重新组合，原有绑定事件失效
        layui.each($("select[name='trainTypeSelect']"),function (index,item) {
            var elem = $(item);
            elem.val(elem.data('state')).parents('div.layui-table-cell').css('overflow', 'visible');;
        })
        form.render();
    });

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        let data = obj.data;
        console.log(data);

        //
        if (obj.event === 'train') {
            layer.open({
                type: 1,//这就是定义窗口类型的属性
                title: [data.trainTitle, 'font-size:15px;text-align: center;height: 30px;line-height:30px;'],//标题
                shade: 0.2,//遮罩透明度 0.3
                // offset: "20%",
                shadeClose : false,//点击遮罩区域是否关闭页面
                offset: ['0px', ''],//位置，高度水平，为空默认居中
                area: ['1100px'],//大小，长宽
                maxmin:true,//是否显示最大化最小化按钮
                // closeBtn: 1, //关闭按钮是否显示 1显示0不显示
                // content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
                content: $('#show_div'),
                success:function (layero,index) {
                    console.log(layero, index);
                    //训练次数
                    $('#traintime').text(data.trainTimes);
                    //训练类别
                    $('#trainTypeSelectItem').val(data.trainType);
                    //训练内容
                    $('#content').val(data.trainContent);
                    //备注
                    $('#remark').val(data.remark);

                    layer.full(index);
                },
                end:function () {
                    reset();
                }
            });
        }

        //删除
        if (obj.event === 'del') {
            layer.confirm('确认删除吗？', function (index) {
                //向服务端发送删除指令
                $.delete(ctx + "/sys/sysAuthority/delete/" + data.authorityId, {}, function (data) {
                    obj.del();
                    layer.close(index);
                })
            });
        }
        //编辑
        else if (obj.event === 'edit') {
            //回显操作表单
            $("#authorityForm").form(data);
            form.render();
        }
    });
});

/**
 * 提交保存
 */
function authorityFormSave() {
    let authorityForm = $("#authorityForm").serializeObject();
    $.post(ctx + "/sys/sysAuthority/save", authorityForm, function (data) {
        layer.msg("保存成功", {icon: 1,time: 2000}, function () {});
        tableIns.reload();
    });
}

function formatSeconds(value) {
    var theTime = parseInt(value);// 秒
    var middle= 0;// 分
    var hour= 0;// 小时

    if(theTime > 60) {
        middle= parseInt(theTime/60);
        theTime = parseInt(theTime%60);
        if(middle> 60) {
            hour= parseInt(middle/60);
            middle= parseInt(middle%60);
        }
    }
    var result = ""+parseInt(theTime)+"秒";
    if(middle > 0) {
        result = ""+parseInt(middle)+"分"+result;
    }
    if(hour> 0) {
        result = ""+parseInt(hour)+"小时"+result;
    }
    return result;
}

var hour,minute,second;//时 分 秒
hour=minute=second=0;//初始化
var millisecond=0;//毫秒
var int;
function reset()//重置
{
    window.clearInterval(int);
    millisecond=hour=minute=second=0;
    $('#counttime').text('00:00:00');
    // document.getElementById('counttime').value='00:00:00:000';
}

function start()//开始
{
    int=setInterval(timer,50);
}

function timer()//计时
{
    millisecond=millisecond+50;
    if(millisecond>=1000)
    {
        millisecond=0;
        second=second+1;
    }
    if(second>=60)
    {
        second=0;
        minute=minute+1;
    }

    if(minute>=60)
    {
        minute=0;
        hour=hour+1;
    }
    $('#counttime').text(toDub(hour)+':'+toDub(minute)+':'+toDub(second));
    // document.getElementById('counttime').text=toDub(hour)+':'+toDub(minute)+':'+toDub(second);

}

function stop()//暂停
{
    window.clearInterval(int);
}
//补零
function toDub(n){
    return n<10?"0"+n:""+n;
}

//开始训练
function starttrain() {
    //先重置
    reset();
    //开始计时
    start();
}

//结束训练
function endtrain(){
    stop();//暂停
}