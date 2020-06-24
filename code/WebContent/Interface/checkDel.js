
function checkDel(id) {

    if (window.confirm("是否删除该单词?")) {

        window.location.href = "DeleteWordServlet?act=link&wordId=" + id;

    }

}

function cancel() {

    window.location.href = "SelectWordsServlet?act=updateSelect";

}


// 批量删除
function confirmDelete() {

    var n = document.deleteForm.wordId.length;

    if (n === 0) {  // 无单词

        alert("单词列表为空!");

        return false;

    }

    // 统计没有选中的个数
    var count = 0;

    for (var i = 0; i < n; i++) {

        if (!document.deleteForm.wordId[i].checked) {

            count++;

        } else {

            break;

        }

    }



    // 单词数量 > 1
    if (n > 1) {

        //没有选择任何单词
        if ( count === n ) {

            alert("请选择需要删除的单词!");

            return false;

        }

    } else {         // 一个单词

        // 只有一个单词并且还没有选择
        if (!document.deleteForm.wordId.checked) {

            alert("请选择需要删除的单词!");

            return false;

        }

    }

    if (window.confirm("真的要删除吗? really?")) {

        document.deleteForm.submit();

        return true;

    }

    return false;

}