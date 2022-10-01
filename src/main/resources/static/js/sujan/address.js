let searchzip = document.getElementById('search');
searchzip.addEventListener('click', ()=>{
    
    let api = 'https://zipcloud.ibsnet.co.jp/api/search?zipcode=';
    let error = document.getElementById('error');
    let input = document.getElementById('zipcode');
    let address1 = document.getElementById('address1');
    let address2 = document.getElementById('address2');
    let param = input.value.replace("-",""); //入力された郵便番号から「-」を削除
    let url = api + param;
    
    fetchJsonp(url, {
        timeout: 10000, //タイムアウト時間
    })
    .then((response)=>{
        error.textContent = ''; //HTML側のエラーメッセージ初期化
        return response.json();  
    })
    .then((data)=>{
	if(data.status  === 400){ //エラー時
            error.textContent = '郵便番号７桁入力してください。';
            address1.value = "";
            address2.value = "";
        }else if(data.results === null){
            error.textContent = '郵便番号から住所が見つかりませんでした。';
            address1.value = "";
            address2.value = "";
        } else {
            address1.value = data.results[0].address1 +data.results[0].address2 ;
            address2.value =  data.results[0].address3;
            address1.readOnly = true;
        }
    })
    .catch((ex)=>{ //例外処理
        console.log(ex);
    });
}, false);