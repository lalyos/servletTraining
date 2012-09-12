curl -X POST -d 'name=lucy&breast=105&basket=C' http://localhost:8080/training/CVServlet
curl -X POST -d 'name=suzy&breast=95&basket=B' http://localhost:8080/training/CVServlet
curl -X POST -d 'name=milf&breast=120&basket=D' http://localhost:8080/training/CVServlet


curl -c cookies.txt http://localhost:8080/training/login?username=jeno
curl -b cookies.txt -d 'food=sor&girl.x=53&girl.y=17&girl=suzy' http://localhost:8080/training/orderForm
curl -b cookies.txt -d 'food=pacal&girl.x=53&girl.y=17&girl=lucy' http://localhost:8080/training/orderForm
curl -b cookies.txt -d 'food=palacsinta&girl.x=53&girl.y=17&girl=suzy' http://localhost:8080/training/orderForm

curl -c cookies.txt http://localhost:8080/training/login?username=jeno
curl -b cookies.txt -d 'food=kola&girl.x=53&girl.y=17&girl=suzy' http://localhost:8080/training/orderForm
curl -b cookies.txt -d 'food=malnaszorp&girl.x=53&girl.y=17&girl=lucy' http://localhost:8080/training/orderForm
curl -b cookies.txt -d 'food=szotyi&girl.x=53&girl.y=17&girl=lucy' http://localhost:8080/training/orderForm
