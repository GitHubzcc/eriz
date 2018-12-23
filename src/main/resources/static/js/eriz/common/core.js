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