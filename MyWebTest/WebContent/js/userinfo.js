$(document).ready(function() {

    function ShowDiv(show_div, bg_div) {
        document.getElementById(show_div).style.display = "block";
        document.getElementById(bg_div).style.display = "block";

        var windowHeight = $(window).height();
        var windowWidth = $(window).width();
        var popupHeight = $("#" + show_div).height();
        var popupWeidth = $("#" + show_div).width();
        var positop = (windowHeight - popupHeight) / 2;
        var posiLeft = (windowWidth - popupWeidth) / 2;
        $("#" + show_div).css({ "left": posiLeft + "px", "top": positop + "px", "display": "block" });
    }

    $("#tbody").click(function() {
        $(this).addClass('tr_hover');
    });
    // 鼠标悬停增加背景色
    $("#tbody").click(function() {
        $(this).addClass('tr_hover');
    });

    // 鼠标离开移除背景色
    $("#tbody").on("mouseout", "tr", function() {
        $(this).removeClass('tr_hover');
    });

    // 动态产生tr里面的input点击事件
    $("#tbody").on("click", "tr input:checkbox", function() {
        if (this.checked == true) {
            $(this).parents("tr").addClass('tr_select');
        } else {
            $(this).parents("tr").removeClass('tr_select');
        }
    });

    // 动态产生table中的删除、修改点击事件
    $('table').on('click', '#btDelete', function() {
        $(this).addClass('btDelete');
    });
    $('table').on('click', '#btUpdate', function() {
        $(this).addClass('btUpdate');
    });

    // 查询
    $("#btSearch").click(function() {
        $.ajax({
            type: "post",
            url: "usersearch",
            data: "data",
            dataType: "json",
            success: function(response) {
                var rows = response.rows;
                total = response.total;
                pageCount = Math.ceil(total / pagesize);
                $("#total").text(total);
                $("pageCount").text(pageCount);
                $("tbody").empty();
                $.each(rows, function(index, row) {
                    var s = JSON.stringify(row);
                    var str = "<tr data='" + s + "'>";
                    str = str + '<td><input type ="checkbox" value=' + row.userName + ' /></td>';
                    str = str + '<td>' + row.userName + ' /></td>';
                    str = str + '<td>' + row.chrName + ' /></td>';
                    str = str + '<td>' + row.mail + ' /></td>';
                    str = str + '<td>' + row.provinceName + ' /></td>';
                    str = str + '<td>' + row.cityName + ' /></td>';
                    str = str + '<a><a href="#" id="btDelete"value=' + row.userName + '>删除</a>';
                    str = str + '<a href="#" id="btUpdate>修改</a></td>';
                    str = str + '</tr>';
                    $("tbody").append(str);
                });
                $('tbody tr:even').addClass('tr_even');
                $('tbody tr:odd').addClass('tr_odd');
            }
        });
    })

    // 删除
    $("#btDelete").click(function() {
        var len = $('tbody tr input:checkbox:checked').length;
        if (len == 0) {
            alert('至少选择一项');
            return;
        }
        var vals = [];
        $('tbody tr input:checkbox:checked').each(function(index, item) {
            vals.push($(this).val());
        });
        $.ajax({
            type: "post",
            url: "deleteUser",
            data: { ids: vals.join(",") },
            dataType: "json",
            success: function(response) {
                alert(response.info);
                if (response.code == 0) {
                    reload();
                }
            }
        });

    });

    // 修改
    $("#btUpdate").click(function() {
        $(this).addClass('ShowDiv');
    });

    // 增加


    function CloseDiv(show_div, bg_div) {
        document.getElementById(show_div).style.display = "none";
        document.getElementById(bg_div).style.display = "none";
    }

});