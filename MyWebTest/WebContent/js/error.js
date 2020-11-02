 var num = 11;
         function calc() {
                if (num >0) {
                   num--;
                   document.getElementById('second').innerHTML = num;
                    } else {
                        location.href = 'login.html'
                    }
                    setTimeout('calc()', 1000);
                }