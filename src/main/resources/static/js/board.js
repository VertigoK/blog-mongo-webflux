$('#btn-save').on('click', function() {
    saveBoard();
});
$('#btn-delete').on('click', function() {
    deleteBoard();
});
$('#btn-update').on('click', function() {
    updateBoard();
});

function saveBoard() {
    let data = {
        title: $('#title').val(),
        content: $('#content').val()
    };
    $.ajax({
        type: 'POST',
        url: '/board',
        data: JSON.stringify(data),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json'
    }).done(function(resp) {
        alert('글이 작성되었습니다.');
        location.href = '/board';
    }).fail(function(error) {
        alert(JSON.stringify(error));
    });
}

function updateBoard() {
    let id = $('#boardId').val();
    let data = {
        title: $('#title').val(),
        content: $('#content').val()
    };
    $.ajax({
        type: 'PUT',
        url: '/board/' + id,
        data: JSON.stringify(data),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json'
    }).done(function(resp) {
        alert('글이 수정되었습니다.');
        location.href = '/board';
    }).fail(function(error) {
        alert(JSON.stringify(error));
    });
}

function deleteBoard() {
    let id = $('#boardId').text();
    $.ajax({
        type: 'DELETE',
        url: '/board/' + id,
        dataType: 'json'
    }).done(function(resp) {
        alert('글이 삭제되었습니다.');
        location.href = '/board';
    }).fail(function(error) {
        alert(JSON.stringify(error));
    });
}
