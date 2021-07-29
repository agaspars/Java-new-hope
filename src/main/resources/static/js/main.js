function setLang(langId) {
    $.get("http://localhost:8090/setLang/" + langId, function(data) {
        location.reload();
    });
}