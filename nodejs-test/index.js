const axios = require('axios')

function restsum() {
    const url = "http://localhost:8080/calculator/sum"
    const payload = {
        "firstNumber": 1,
        "secondNumber": 2
    }
    return axios.post(url, payload).then((res) => {
        console.log(res.data)
    }).catch((errror) => {
        console.log(errror.message)
    })
}


function soapsum() {
    const url = "http://localhost:8081/ws/"

    var xmlBodyStr = `<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:us="http://soa.com/soap/calculator">
    <soapenv:Header/>
    <soapenv:Body>
        <us:getSumRequest>
            <us:firstNumber>10</us:firstNumber>
            <us:secondNumber>10</us:secondNumber>            
        </us:getSumRequest>
    </soapenv:Body>
</soapenv:Envelope>`;

    const config = {
  headers: {
    'Content-Type': 'text/xml'
  }
    }
    return axios.post(url, xmlBodyStr, config).then((res) => {
        console.log(res.data)
    }).catch((errror) => {
        console.log(errror.message)
    })
}
setImmediate(async () => {
    await restsum()
})