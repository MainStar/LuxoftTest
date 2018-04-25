import React from 'react';

export default


var xhr = new XMLHttpRequest();
xhr.open('POST', 'api/loadFile/statistic', true);
xhr.onload = function(){
     alert(xhr.responseText);
}
xhr.send();