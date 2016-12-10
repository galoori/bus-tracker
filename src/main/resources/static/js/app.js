    var url = "ws://localhost:8090/location/feed";
    var ws;
    var map;
    var marker1;
    var marker2;
    var markers = [];
    var bounds;

    var infowindow1;
    var infowindow2;


    function connect() {
        ws = new WebSocket(url);
        ws.onopen = function() {
            console.log("Connected to server...");
        }
        ws.onmessage = function(e) {

            var ticker = JSON.parse(e.data);
            console.log(ticker[0].location + " .... "+ ticker[1].location)

            marker1.setPosition(ticker[0].location);
            bounds.extend(marker1.position);
            map.fitBounds(bounds);

            infowindow1.setContent("<div><p>Latitude: "+ticker[0].location.lat+"</p><p>Longitude: "+ticker[0].location.lng+"</p></div>");

            marker2.setPosition(ticker[1].location);
            bounds.extend(marker2.position);
            map.fitBounds(bounds);

            infowindow2.setContent("<div><p>Latitude: "+ticker[1].location.lat+"</p><p>Longitude: "+ticker[1].location.lng+"</p></div>");
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
          zoom: 17
        });

        marker1 = new google.maps.Marker({
                  position: capgemini,
                  map: map,
                  label: "1",
                  //icon: "http://icons.iconarchive.com/icons/iconshock/real-vista-transportation/48/vintage-car-icon.png",
                  title: 'Bus-1'
                });

        infowindow1 = new google.maps.InfoWindow({
                  content: "<div><h4>hi</h4></div>"
                });

        marker1.addListener('mouseover', function() {
                  infowindow1.open(map, marker1);
                });

/*        marker1.addListener('mouseout', function() {
                  infowindow1.close();
                });*/

        bounds = new google.maps.LatLngBounds();
        bounds.extend(marker1.position);
        map.fitBounds(bounds);

        marker2 = new google.maps.Marker({
                  position: capgemini,
                  map: map,
                  label: "2",
                  //icon: "http://icons.iconarchive.com/icons/iconshock/real-vista-transportation/48/vintage-car-icon.png",
                  title: 'Bus-2'
                });

        infowindow2 = new google.maps.InfoWindow({
                  content: "<div><h4>hi</h4></div>"
                });

        marker2.addListener('mouseover', function() {
                  infowindow2.open(map, marker2);
                });

/*        marker2.addListener('mouseout', function() {
                  infowindow2.close();
                });*/

        bounds = new google.maps.LatLngBounds();
        bounds.extend(marker2.position);
        map.fitBounds(bounds);
    }