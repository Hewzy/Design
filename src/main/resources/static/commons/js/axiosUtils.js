//引入Axios
//document.write("<script language='javascript' src='pub/js/axios.min.js'></script>");


/**
 * Axios post请求函数
 *
 * @param getUrl
 *            请求链接
 * @param getParams
 *            请求链接
 * @param funcSuc
 *            请求成功的回调函数
 * @param funFail
 *            请求失败的回调函数
 * @constructor
 */

function callAxiosPostFile(url, params, funcSuc, funFail) {
    axios.post(url, params,{   headers: {
            'Content-Type': 'multipart/form-data'
        }}).then(function (response) {
        // 成功回调函数
        funcSuc(response.data)
    })
        .catch(function (error) {
            // errorClass(error)
            // 失败回调函数
            funFail(error.response)
        });
}


/**
 * Axios get请求函数
 *
 * @param getUrl
 *            请求链接
 * @param getParams
 *            请求链接
 * @param funcSuc
 *            请求成功的回调函数
 * @param funFail
 *            请求失败的回调函数
 * @constructor
 */
function callAxiosGet(getUrl, getParams, funcSuc, funFail) {
    axios.get(getUrl, {params: getParams}, {
        headers: {
            'X-Requested-With': 'XMLHttpRequest',
            'Content-Type': 'application/json;charset=UTF-8'
        }
    }).then(function (response) {
        // 断言
        // 成功回调
        funcSuc(response.data)
    })
        .catch(function (error) {
            // 失败回调
            // errorClass(error)
            funFail(error.response)
        });
}
/**
 * Axios get请求函数
 *
 * @param getUrl
 *            请求链接
 * @param funcSuc
 *            请求成功的回调函数
 * @param funFail
 *            请求失败的回调函数
 * @constructor
 */
function callAxiosGetNoParam(getUrl, funcSuc, funFail) {
    axios.get(getUrl,{
        headers: {
            'X-Requested-With': 'XMLHttpRequest',
            'Content-Type': 'application/json;charset=UTF-8'
        }
    }).then(function (response) {
        // 断言
        // 成功回调
        funcSuc(response.data)
    })
        .catch(function (error) {
            // 失败回调
            funFail(error.response)
        });
}
/**
 * Axios只带请求url，无参数与回掉
 *
 * @param url
 *            请求url
 */
function callAxiosGetNoParamsAndFun(url) {
    axios.get(url, {
        headers: {
            'X-Requested-With': 'XMLHttpRequest',
            'Content-Type': 'application/json;charset=UTF-8'
        }
    }).then(function (response) {
        console.log(response);
    })
        .catch(function (error) {
            // errorClass(error)
            console.log(error);
        });
}

/**
 * Axios Get请求无回掉函数
 *
 * @param url
 * @param params
 */
function callAxiosGetNoFun(url,params) {
    axios.get(url, {params: params}, {
        headers: {
            'X-Requested-With': 'XMLHttpRequest',
            'Content-Type': 'application/json;charset=UTF-8'
        }
    }).then(function (response) {
        console.log(response)
    })
        .catch(function (error) {
            // errorClass(error)
            console.log(error)
        });
}

/**
 * Axios post请求函数
 *
 * @param getUrl
 *            请求链接
 * @param getParams
 *            请求链接
 * @param funcSuc
 *            请求成功的回调函数
 * @param funFail
 *            请求失败的回调函数
 * @constructor
 */

function callAxiosPost(url, params, funcSuc, funFail) {
    axios.post(url, params, {
        headers: {
            'X-Requested-With': 'XMLHttpRequest',
            'Content-Type': 'application/json;charset=UTF-8'
        }
    }).then(function (response) {
        // 成功回调函数
        funcSuc(response.data)
    }).catch(function (error) {
        // errorClass(error)
        // 失败回调函数
        funFail(error.response)
    });
}
/**
 * Axios带参数，无回掉函数的 Post请求
 *
 * @param url
 * @param domain
 */
function callAxiosNoFun(url, domain) {
    axios.post(url, JSON.stringify(domain), {
        headers: {
            'X-Requested-With': 'XMLHttpRequest',
            'Content-Type': 'application/json;charset=UTF-8'
        }
    });
}


