function loadFile(){
    var xhr = new XMLHttpRequest();
    xhr.open('POST', "http://localhost:8080/LuxoftTest/api/loadFile/statistic", true);
    xhr.send();
    xhr.onload = function(){
        alert(xhr.Text);
    }
}