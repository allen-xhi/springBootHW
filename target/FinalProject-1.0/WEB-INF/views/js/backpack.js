
      function initMap() {
        var central_park = new google.maps.LatLng(40.764243, -73.973049);
            //var infowindow = new google.maps.InfoWindow();
                map = new google.maps.Map(document.getElementById("map"), {
                center: central_park,
                zoom: 17
            });
                     
        var input = document.getElementById('pac-input');

        var autocomplete = new google.maps.places.Autocomplete(input);
        autocomplete.bindTo('bounds', map);

        // Specify just the place data fields that you need.
        autocomplete.setFields(['place_id', 'geometry', 'name']);

        map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
         

        autocomplete.addListener('place_changed', function() {    
        

        var place = autocomplete.getPlace();

            //console.log("1=" + location);

          if (!place.geometry) {
            return;
          }

          if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
          } else {
            map.setCenter(place.geometry.location);
            map.setZoom(17);
          }    

             //console.log("2=" + place.geometry.location);
      
       
        var request={
                placeId:place.place_id,
                radius:"1",        
              
                    }

                    
                    //console.log("3=" + location);

    //    function addRequest(loc){
        
            //console.log("2=" + request.location);

        var service = new google.maps.places.PlacesService(map);
            service.getDetails(request, callback);
            //console.log("3=" + 2)     
        // }
      


        var marker;
      function callback(request, status) {

        var place = request;
        var photos; 
                
        marker = new google.maps.Marker({
        position: request.geometry.location,
        map: map,
        title: place.name,
       });

        //console.log("4=" + position)
            
        var infowindow = new google.maps.InfoWindow({
        content: place.name
        });
        infowindow.open(map, marker);

       
        marker.addListener("click",function(){
         if (status == google.maps.places.PlacesServiceStatus.OK) {
        	 document.getElementById('slide').innerHTML = "";
        	 document.getElementById('open').innerHTML = "";
        	 
        	    let placeid = document.querySelector('#placeid');
		        let rating = document.querySelector('#rating');
		        let spot = $(".123");
		        let website = document.querySelector('#website');
		        let tel = document.querySelector('#tel');
		        let country = document.querySelector('#country');
		        let city = document.querySelector('#city');
		        let address = document.querySelector('#address');
		        let opening = document.querySelector('#open');

		        let reviewEl = document.querySelector('.review-list');
		        let photosEl = document.querySelector('#photo');
		        var img = document.createElement("img");
		        //photos = request.photos[0].getUrl({maxWidth:400, maxHeight:400});
		       // img.setAttribute('src', photos + ".jpg");
     	        //img.setAttribute("class", "qoo");
		       //document.getElementById("photo").appendChild(img);
		        
		       for(let photo of place.photos){
	                  var text ;
	                  let img = document.createElement("img"); 
	                 console.log(photo.getUrl({maxWidth:300, maxHeight:300}));
	                        text = ` ${photo.getUrl({maxWidth:400, maxHeight:400})} `+ ".jpg" ;
	                        img.setAttribute('src', text);
	                        document.getElementById('slide').appendChild(img);
	                  
	                };
		        
	                
	                var counter = 0, // 一開始要顯示的圖，0 的話就是顯示第一張
	                slide = document.querySelector('#slide'),
	                items = slide.querySelectorAll('img'), // 抓取所有 img
	                itemsCount = items.length, // 圖片總數 
	                prevBtn = document.createElement('a'), // 上一張按鈕
	                nextBtn = document.createElement('a'), // 下一張按鈕
	                timer = 1500, // 4 秒換圖
	                interval = window.setInterval(showNext, timer);  // 設定循環

	            prevBtn.classList.add('prev'); // 幫上一張按鈕加 class＝"prev" 給 CSS 指定樣式用
	            nextBtn.classList.add('next'); // 幫下一張按鈕加 class＝"next" 給 CSS 指定樣式用
	            slide.appendChild(prevBtn); // 將按鈕加到 #slide 裡
	            slide.appendChild(nextBtn);

	            // 帶入目前要顯示第幾張圖 
	            var showCurrent = function(){
	                var itemToShow = Math.abs(counter % itemsCount); // 取餘數才能無限循環
	                [].forEach.call( items, function(el){
	                    el.classList.remove('show'); // 將所有 img 的 class="show" 移除
	                });
	                items[itemToShow].classList.add('show'); // 將要顯示的 img 加入 class="show"
	            };

	            function showNext(){
	                counter++; // 將 counter+1 指定下一張圖
	                showCurrent();
	            }

	            function showPrev(){
	                counter--; // 將 counter－1 指定上一張圖
	                showCurrent();
	            }

	            // 滑鼠移到 #slider 上方時，停止循環計時
	            slide.addEventListener('mouseover', function(){
	                interval = clearInterval(interval);
	            });

	            // 滑鼠離開 #slider 時，重新開始循環計時
	            slide.addEventListener('mouseout', function(){
	                interval = window.setInterval(showNext, timer);
	            });

	            // 綁定點擊上一張，下一張按鈕的事件
	            nextBtn.addEventListener('click', showNext, false);
	            prevBtn.addEventListener('click', showPrev, false);

	            // 一開始秀出第一張圖，也可以在 HTML 的第一個 img 裡加上 class="show"
	            items[0].classList.add('show');
		    
				//placeid.innerHTML =   place.address_components[0].long_name ;
		        rating.innerHTML =    place.rating ;
		        spot.html(place.name) ;
		        spot.attr("id",place.name);
		        website.innerHTML =   place.website ;
		        tel.innerHTML =       place.formatted_phone_number ; 
		        country.innerHTML =   place.address_components[6].long_name ;
		        city.innerHTML =      place.address_components[5].long_name ;
		        address.innerHTML =   place.formatted_address ;

          for(let opening of place.opening_hours.weekday_text){
                    let ad = document.createElement('ad');
                        ad.innerHTML = `<div>${opening}</div>`;
                        document.getElementById('open').appendChild(ad);
              } 
                            

		        
          document.getElementById('rl').innerHTML = "";
          for (let review of place.reviews){  
               let li = document.createElement('li');
               li.innerHTML = `<div><img STYLE="Width:40px; Height:40px;" src="${review.profile_photo_url}"</img> ${review.author_name}</div>
                   			   <em>${review.text}</em>
                               <div>Rating: ${review.rating} star(s) ${review.relative_time_description}</div>`;
                   reviewEl.appendChild(li);
                   }
          
          temp.innerHTML = place.reviews[1].text;
                 }         
              });
            };
          });
        } 

       

