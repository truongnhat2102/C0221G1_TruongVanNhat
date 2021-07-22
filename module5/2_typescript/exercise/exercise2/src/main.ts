console.log("start");
function resolveAfter() {
    return new Promise(function (resolve, reject) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.onload = function () {
            if (this.status == 200 ){
                resolve(xmlHttp.responseText);
            } else {
                reject("error call api");
            }
        };
        xmlHttp.open("GET", "https://api.github.com/search/repositories?q=angular");
        xmlHttp.send();
    });
}

async function asyncCall() {
    const result = await resolveAfter();
    console.log(result);
}

asyncCall();
