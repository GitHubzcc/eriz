$(function () {
    initFilterText()
});

//初始化更多查询
function initFilterText() {
    $(".ui-filter-text").click(function () {
        if ($('.ui-filter-list').is(":hidden")) {
            $(this).css('border-bottom-color', '#ccc');
            $(".ui-filter-list").slideDown(10);
            $(this).addClass("active");

            $(this).find('i').removeClass('fa-angle-up');
            $(this).find('i').addClass('fa-angle-down');

        } else {
            $(this).css('border-bottom-color', '#ccc');
            $(".ui-filter-list").slideUp(10);
            $(this).removeClass("active");

            $(this).find('i').removeClass('fa-angle-down');
            $(this).find('i').addClass('fa-angle-up');
        }
    });
    $(".profile-nav li").click(function () {
        $(".profile-nav li").removeClass("active");
        $(".profile-nav li").removeClass("hover");
        $(this).addClass("active");
    }).hover(function () {
        if (!$(this).hasClass("active")) {
            $(this).addClass("hover");
        }
    }, function () {
        $(this).removeClass("hover");
    });

    /*var $sp = $('.selectpicker');
    if (!$.util.isEmptyJquery($sp)) {
        $sp.on('show.bs.select', function (e) {
            var $cb = $(".ui-select[type='comboBoxTree2']");
            if (!$.util.isEmptyJquery($cb)) {
                $cb.ComboBoxTree2("hidePanel");
            }
        });
    }*/
}

/**
 * 时间戳转时间格式
 * @param datetime 时间戳
 * @param fmt 时间格式。yyyy-MM-dd 或者yyyy-MM-dd hh:mm:ss等格式
 * @returns {*} 时间格式
 * @constructor
 */
Format = function (datetime,fmt) {
    if (parseInt(datetime)==datetime) {
        if (datetime.length==10) {
            datetime=parseInt(datetime)*1000;
        } else if(datetime.length==13) {
            datetime=parseInt(datetime);
        }
    }
    datetime=new Date(datetime);
    var o = {
        "M+" : datetime.getMonth()+1,                 //月份
        "d+" : datetime.getDate(),                    //日
        "h+" : datetime.getHours(),                   //小时
        "m+" : datetime.getMinutes(),                 //分
        "s+" : datetime.getSeconds(),                 //秒
        "q+" : Math.floor((datetime.getMonth()+3)/3), //季度
        "S"  : datetime.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}