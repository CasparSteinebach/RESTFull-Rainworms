// basis functies

function $(x) {
    return document.getElementById(x);
}

function XHR(){
    return new XMLHttpRequest();
}

// plaatjes inladen

function dobbelsteenById(id) {
    var xhr = XHR();
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var myArr = JSON.parse(this.responseText);
            var worp=worpById(id);
            console.log("hallo" + myArr.worp);
            $(id).innerHTML= dobbelplaatjes(worp, id);
        }
        return myArr;
    };
    xhr.open("GET", "http://localhost:8083/api/dobbelsteen/dobbelsteen/"+id, true)
    xhr.send();
}

function dobbelplaatjes(gegooideSteen, idElement){
    if (gegooideSteen == 1) {
        console.log(gegooideSteen);
        document.getElementById(idElement).innerHTML = "<img src=\"dice-1-nb.png\" height=\"150\" width=\"150\"/>";
        
    } else if (gegooideSteen == 2) {
        console.log(gegooideSteen);
        $(idElement).innerHTML = "<img src=\"dice-2-nb.png\" height=\"150\" width=\"150\"/>";
      
    } else if (gegooideSteen == 3) {
        console.log(gegooideSteen);
        $(idElement).innerHTML = "<img src=\"dice-3-nb.png\" height=\"150\" width=\"150\"/>";
        
    } else if (gegooideSteen == 4) {
        console.log(gegooideSteen);
        $(idElement).innerHTML = "<img src=\"dice-4-nb.png\" height=\"150\" width=\"150\"/>";
       
    } else if (gegooideSteen == 5) {
        console.log(gegooideSteen);
        $(idElement).innerHTML = "<img src=\"dice-5-nb.png\" height=\"150\" width=\"150\"/>";
       
    } else {
        console.log(gegooideSteen);
        $(idElement).innerHTML = "<img src=\"regenworm-nb.png\" height=\"150\" width=\"150\"/>";
       
    }
}

// opvragen stenen

function statusById(id) {
    var xhr = XHR();
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var status = JSON.stringify(this.responseText);
            console.log("status van dobbelsteen " + id + "is " + status);
        }
        //return status;
    };
    xhr.open("GET", "http://localhost:8083/api/dobbelsteen/checkstatus/"+id, true)
    xhr.send();
}

function worpById(id) {
    var xhr = XHR();
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var myArr = JSON.parse(this.responseText);
            console.log("hallo" + myArr.worp);
            dobbelplaatjes(myArr.worp, id);
        }
        return myArr;
    };
    xhr.open("GET", "http://localhost:8083/api/dobbelsteen/dobbelsteen/"+id, true)
    xhr.send();
}
   
function dobbelsteenToevoegen() {
    var obj = {};
    objJSON = JSON.stringify(obj);
    var xhr = XHR();
    xhr.onreadystatechange = function () {
        console.log("dobbelsteen aangemaakt");
    }
    xhr.open("POST", "http://localhost:8083/api/dobbelsteen/new-dobbelsteen", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(objJSON);
}

// resetten stenen

function resetStenenById(id){
    var xhr = XHR();
    xhr.onreadystatechange = function() {
        
    }
    xhr.open("PUT", "http://localhost:8083/api/dobbelsteen/resetsteen/"+id, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}


function dobbelstenenToevoegen() {
    for (var i = 0; i < 8 ; i++){
        dobbelsteenToevoegen();
    };
        stenenGooien();
        stenenLaden();
        scoreVasteStenen();
}
    
function stenenGooien(){
    for(var i = 1; i < 9; i++){
        dobbelsteenWorpGooienbyId(i);
    }
}

function stenenLaden() {
    for (var i = 1; i < 9; i++){
        worpById(i)
        
        //dobbelNaLaden(i);
    }
}

function stenenResetten() {
        for (var i = 1; i < 9; i++){
        resetStenenById(i)
    }
}

function veranderKlasse(id) {
    dobbelsteenStatusveranderen(id);
    scoreVasteStenen();
    $(id).classList.toggle("dobbelsteen-vast");
    statusById(id); 

}

function dobbelsteenStatusveranderen(idElement) {
    var xhr = XHR();
    xhr.onreadystatechange = function () {    
         
    }
    xhr.open("PUT", "http://localhost:8083/api/dobbelsteen/changestatus/"+ idElement, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
   
}

function dobbelsteenWorpGooienbyId(idElement) {
    var xhr = XHR();
    xhr.onreadystatechange = function () {
        console.log("worp steen verandert");
    }
    xhr.open("PUT", "http://localhost:8083/api/dobbelsteen/fillworp/"+idElement, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}

function generateTable() {
    var y = "<div class=\"container\">";
    var i;
 for (i = 1; i < 5; i++){
    y +=`<div class="dobbelsteen" id="${i}" onclick="veranderKlasse('${i}'); return false;"></div>`
 }
 y += `</div><div class=\"container\">`
    for (i = 5; i < 9; i++){
        y +=`<div class="dobbelsteen" id="${i}" onclick="veranderKlasse('${i}'); return false;"></div>`
    }
 y += `</div>`
//         `
    document.getElementById("table").innerHTML = y;

}


function scoreVasteStenen() {
    var xhr = XHR();
    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var scorestenen = JSON.parse(this.responseText);
            $("scorebord").innerHTML = scorestenen;
            console.log("score speler na selectie dobbelsteen: " + scorestenen);
        }
    };
    xhr.open("GET", "http://localhost:8083/api/dobbelsteen/getcalculatedscore/", true)
    xhr.send();
}
    // xhr.onreadystatechange = function () {
    //     if (this.readyState == 4) {

    //         var obj = JSON.parse(this.responseText);
    //         var c;
    //         for (c = 0; c < obj.length; c++) {
    //             if (obj[c].maand == document.getElementById("maand-formulier").value && obj[c].jaar == document.getElementById("jaar-formulier").value) {
    //                 if(obj[c].statusGoedkeuring == "OPEN" ){
    //                     var x;
    //                     for (x = 0; x < obj[c].werkdag.length; x++) {
    //                         y += `<tr id="${obj[c].werkdag[x].id}">
    //               <td id="datum${x}">${obj[c].werkdag[x].datumDag}</td>
    //               <td><input type="text" id="opdracht${x}" onchange="urenOpslaanDag()" size="2" placeholder="${obj[c].werkdag[x].opdrachtUren}"></td>
    //               <td><input type="text" id="overwerk${x}" onchange="urenOpslaanDag()" size="2" placeholder="${obj[c].werkdag[x].overwerkUren}"></td>
    //               <td><input type="text" id="verlof${x}" onchange="urenOpslaanDag()" size="2" placeholder="${obj[c].werkdag[x].verlofUren}"></td>
    //               <td><input type="text" id="ziektedag${x}" onchange="urenOpslaanDag()" size="2" placeholder="${obj[c].werkdag[x].ziekteDag}"></td>
    //               <td><input type="text" id="training${x}" onchange="urenOpslaanDag()" size="2" placeholder="${obj[c].werkdag[x].trainingsUren}"></td>
    //               <td><input type="text" id="overig${x}" onchange="urenOpslaanDag()" size="2" placeholder="${obj[c].werkdag[x].overigeUren}"></td>
    //               <td><input type="text" id="verklaring${x}" onchange="urenOpslaanDag()" placeholder="${obj[c].werkdag[x].verklaring}"></td>
    //               </tr>
    //               `
    //                     }
    //                 }
    //             }
    //         }
    //         y += `</tbody></table>`;
    //
    //
    //         document.getElementById("showUrenformulier").innerHTML = y;
    //     }
    // };
    // xhr.open("GET", "http://173.212.208.199:1337/api/gebruiker/" + localStorage.getItem("userId") + "/urenformulieren/", true);
    // xhr.setRequestHeader("Authorization", localStorage.getItem("token"));
    // xhr.send();



