
const host = "http://localhost:8080/topdeck"; //测试环境
// const host="/topdeck";// 生产环境


function navTo(path) {
  window.parent.location.href = path;
}

function toUrl(path) {
  window.open(path);
}