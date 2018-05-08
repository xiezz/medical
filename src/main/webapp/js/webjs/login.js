function test(){
$('#loginform').submit(function() {
    $.ajax({
        cache: true,
        type: "POST",
        url: login / login,
        data: $('#loginform').serialize(),// 你的formid
        async: false,
        error: function (request) {
            alert("Connection error");
        },
        success: function (data) {
            var parsedJson = jQuery.parseJSON(data);
            alert(parsedJson.name);
        }
    });
});

}