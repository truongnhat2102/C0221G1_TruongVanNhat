var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
console.log("start");
function resolveAfter() {
    return new Promise(function (resolve, reject) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.onload = function () {
            if (this.status == 200) {
                resolve(xmlHttp.responseText);
            }
            else {
                reject("error call api");
            }
        };
        xmlHttp.open("GET", "https://api.github.com/search/repositories?q=angular");
        xmlHttp.send();
    });
}
function asyncCall() {
    return __awaiter(this, void 0, void 0, function* () {
        const result = yield resolveAfter();
        console.log(result);
    });
}
asyncCall();
//# sourceMappingURL=main.js.map