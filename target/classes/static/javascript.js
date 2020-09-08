function $(x){
    return document.getElementById(x);
}

function XHR(){
    return new XMLHttpRequest();
}

function dobbelsteenId(id) {
    var xhr = XHR();
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var idElement = $(id);
            var gegooideSteen = JSON.parse(this.responseText);
            dobbelplaatjes(dobbelsteenById(id), idElement);
            dobbelsteenToevoegen(idElement, gegooideSteen);
        }
    };
    xhr.open("GET", "http://localhost:8083/api/speler/worp", true)
    xhr.send();
}

function dobbelsteenById(id) {
    var xhr = XHR();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.responseText);
            var worp=worpById(id);
            console.log("hallo" + worp);
            $(id).innerHTML= dobbelplaatjes(worp, id);
        }
    };
    xhr.open("GET", "http://localhost:8083/api/dobbelsteen/dobbelsteen/"+id, true)
    xhr.send();
}

function worpById(id) {
    var xhr = XHR();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var Elementid = $(id);
            var worp = JSON.parse(this.responseText);
            console.log(worp);
            if (worp === 1) {
                Elementid.innerHTML = "1";
            } else {Elementid.innerHTML="in ieder geval iets"};
        }
    }
        return worp;
    };
    xhr.open("GET", "http://localhost:8083/api/dobbelsteen/worp/"+id, true)
    xhr.send();
}

function dobbelsteenToevoegen() {
    var obj = {};
    objJSON = JSON.stringify(obj);
    var xhr = XHR();
    xhr.onreadystatechange = function () {
        console.log("dobbelsteen aangemaakt met id:" + obj.id);
    }
    xhr.open("POST", "http://localhost:8083/api/dobbelsteen/new-dobbelsteen", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(objJSON);
}

function dobbelplaatjes(gegooideSteen, idElement){
    if (gegooideSteen === 1) {
        console.log(gegooideSteen);
        idElement.innerHTML = "<img src=\"dice-1-nb.png\" height=\"150\" width=\"150\"/>";
        idElement.value = gegooideSteen;
    } else if (gegooideSteen === 2) {
        console.log(gegooideSteen);
        idElement.innerHTML = "<img src=\"dice-2-nb.png\" height=\"150\" width=\"150\"/>"
        idElement.value = gegooideSteen;
    } else if (gegooideSteen === 3) {
        console.log(gegooideSteen);
        idElement.innerHTML = "<img src=\"dice-3-nb.png\" height=\"150\" width=\"150\"/>"
        idElement.value = gegooideSteen;
    } else if (gegooideSteen === 4) {
        console.log(gegooideSteen);
        idElement.innerHTML = "<img src=\"dice-4-nb.png\" height=\"150\" width=\"150\"/>"
        idElement.value = gegooideSteen;
    } else if (gegooideSteen === 5) {
        console.log(gegooideSteen);
        idElement.innerHTML = "<img src=\"dice-5-nb.png\" height=\"150\" width=\"150\"/>"
        idElement.value = gegooideSteen;
    } else {
        console.log(gegooideSteen);
        idElement.innerHTML = "<img src=\"regenworm-nb.png\" height=\"150\" width=\"150\"/>";
        idElement.value = gegooideSteen;
    }
}

function veranderKlasse(id) {
    var waarde = 5;
    $(id).className = "dobbelsteen";
    $(id).classList.add("dobbelsteen-vast");
    $(id).id = "vast";
}

function dobbelsteenStatusveranderen(idElement) {
    var xhr = XHR();
    xhr.onreadystatechange = function () {
        console.log("status steen verandert");
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
    xhr.open("PUT", "http://localhost:8083/api/dobbelsteen/fillworp/"+ idElement, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}

function generateTable() {
    var y = "<div class=\"container\">";
    var i;
    var xhr = new XMLHttpRequest();
 for (i = 1; i < 5; i++){
    y +=`<div class="dobbelsteen" id="${i}" onclick="veranderKlasse('${i}'); return false;"></div>`
 }
 y += `</div><div class=\"container\">`
    for (i = 6; i < 9; i++){
        y +=`<div class="dobbelsteen" id="${i}" onclick="veranderKlasse('${i}'); return false;"></div>`
    }
 y += `</div>`
//     y += `<div class="container">
//     <div class="dobbelsteen" id="1" onclick="dobbelsteenToevoegen('1'), veranderKlasse('1'); return false;"></div>
//     <div class="dobbelsteen" id="2" onclick="veranderKlasse('2'); return false;"></div>
//     <div class="dobbelsteen" id="3" onclick="veranderKlasse('3'); return false;"></div>
//     <div class="dobbelsteen" id="4" onclick="veranderKlasse('4'); return false;"></div>
// </div>
//         `
    document.getElementById("table").innerHTML = y;

}

function dobbelNaLaden(id){
    dobbelsteenToevoegen(id);
    dobbelsteenWorpGooienbyId(id);
    worpById(id);
    console.log(worpById(id));
    dobbelplaatjes(worp,$(id));
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



