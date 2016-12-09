    var url = "ws://localhost:8090/location/feed";
    var ws;
    var map;
    var marker;

    function connect() {
        ws = new WebSocket(url);
        ws.onopen = function() {
            console.log("Connected to server...");
        }
        ws.onmessage = function(e) {
            var loc = JSON.parse(e.data);
            console.log(loc)
            marker.setPosition(loc);
        }
    }

    function disconnect() {
        ws.close();
        console.log("Disconnected from server...")
    }

    function initMap() {

        var capgemini = {lat: 17.420438, lng: 78.337980};

        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 17.420438, lng: 78.337980},
          zoom: 15
        });
        marker = new google.maps.Marker({
                  position: capgemini,
                  map: map,
                  title: 'Capgemini!'
                });
    }