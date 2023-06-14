/**
 * 
 */
let slideIndex = 0;
let totalSlides;
let test;
 window.addEventListener('DOMContentLoaded', (evt) =>	{
	setCategories();
	promotionSliding();
	getProductItemList(0, 0);
	setMoreBtn();
	getCategoryItems();
});

// 카테고리 클릭 이벤트
function getCategoryItems()	{
	let category = document.querySelector('.section_event_tab .event_tab_lst');
	
	
	
	category.addEventListener('click', function(evt)	{
		let clickCategory = evt.target;
		let active = document.querySelector('.section_event_tab .event_tab_lst .active');		
	
		active.classList.remove('active');		
		
		let categoryID = 0;
		
		if(clickCategory.tagName === 'A')
		{
			categoryID = clickCategory.parentElement.getAttribute('data-category');
			clickCategory.classList.add('active');	
		}
		else if(clickCategory.tagName === "SPAN")
		{
			let anchorTag = clickCategory.parentElement;
			anchorTag.classList.add('active');		
			
			categoryID = anchorTag.parentElement.getAttribute('data-category');
		}
		else if(clickCategory.tagName === 'LI')
		{
			let anchorTag = clickCategory.firstChildElement;
			anchorTag.classList.add('active');
			categoryID = clickCategory.getAttribute('data-category');
		}
		clearProductItem();
		getProductItemList(Number(categoryID), 0);		 
	});
}

// 카테고리 메뉴 세팅
function setCategories()	{
	
	let oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function()	{
		let list = JSON.parse(this.responseText);		
		inputCategories(list);
	});
	
	oReq.open("GET", "./api/categories");
	oReq.send();
	
}

function inputCategories(list)	{
	let categoriesUL = document.querySelector('.section_event_tab .event_tab_lst');
	let template = document.querySelector('#categories').innerHTML;	
	
	let liTag = template.replaceAll('{id}', '0').replaceAll('{categoryName}', '전체리스트').replaceAll('anchor', 'anchor active');
	
	
	categoriesUL.innerHTML += liTag;
	
	for(let i = 0; i < list.items.length; i++)
	{
		liTag = template.replaceAll('{id}', list.items[i].id)
						.replaceAll('{categoryName}', list.items[i].name);
								
		
		categoriesUL.innerHTML += liTag;		
	}	
}

// MoreBtn 기능
function setMoreBtn()	{
	let moreBtn = document.querySelector('.btn');
	
	moreBtn.addEventListener('click', () => 	{
		let startPointer = 0;
		let categoryId = getActiveCategoryId();		
		
		startPointer = getDisplayItemCount();
		
		
		getProductItemList(categoryId, startPointer);
	});
}

function getActiveCategoryId()	{
	let activeCategoryli = document.querySelector('.section_event_tab .tab_lst_min .item .active').parentElement;
	let categoryId = activeCategoryli.dataset.category;
	
	return categoryId;
		
}


// Product Item 디스플레이
function getProductItemList(categoryId, start)	{
	let params = '?categoryId=' + categoryId + '&start=' + start;
	
	let oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function()	{
		let list = JSON.parse(this.responseText);
		
		setTotalCount(list["totalCount"]);
		setProductItem(list["items"]);
		checkMoreItem(list["totalCount"]);		
	});
	
	oReq.open("GET", "./api/products" + params);
	oReq.send();
	
}


function getDisplayItemCount()	{	
	let ulEventBox = document.querySelectorAll('.lst_event_box');
	let returnValue = 0;
	
	for(let item of ulEventBox )	{
	returnValue += item.childElementCount;
	}
	
	return returnValue;
}

// 모든 아이템이 로드되면, 더보기 아이콘 해제
function checkMoreItem(totalCount)	{
	let displayItemCount = getDisplayItemCount();
	let moreBtn = document.querySelector('.btn');
	if(totalCount == displayItemCount)	{		
		moreBtn.style.display = 'none';
	}
	else		{
		moreBtn.style.display = 'block';
	}
}

function clearProductItem()	{
	let ulEventBox = document.querySelectorAll('.lst_event_box');
	
	for(let i = 0; i < ulEventBox.length; i++)
	{
		while(ulEventBox[i].firstChild)
		{
			ulEventBox[i].removeChild(ulEventBox[i].firstChild);
		}
	}
}

function setProductItem(productItem)	{
	let template = document.querySelector('#itemList').innerHTML;
	let ulEventBox = document.querySelectorAll('.lst_event_box');
	
	for(let i = 0; i < productItem.length; i++)
	{
		let liTag = template.replaceAll('{id}', productItem[i].productId)
								.replaceAll('{description}', productItem[i].productDescription)
								.replaceAll('{placeName}', productItem[i].placeName)
								.replaceAll('{content}', productItem[i].productContent)
								.replaceAll('{productImageUrl}', productItem[i].productImageUrl);
								
		
		i < 2 ? ulEventBox[0].innerHTML += liTag : ulEventBox[1].innerHTML += liTag;
		//ulEventBox[0].innerHTML += liTag;
	}
	
}

function setTotalCount(totalCount)	{
	eventCount = document.querySelector('.event_lst_txt .pink');
	eventCount.innerText = totalCount + '개';
}


//프로모션 슬라이딩 기능
function promotionSliding()	{
	getPromotionData();
}


function getPromotionData()	{	
	
	let oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function()	{
		let list = JSON.parse(this.responseText);
		let template = document.querySelector('#promotionItem').innerHTML;
		let ulPromotion = document.querySelector(".container_visual .visual_img");
		
		for(let i = 0;i < list.items.length; i++)		{
			 let promotionItem = template.replace('{file_name}', list.items[i].file_name)
				.replace('{description}', list.items[i].description)
				.replace('{content}', list.items[i].content)
				.replace('{place_name}', list.items[i].place_name)
				.replace('\n', ''); 
			ulPromotion.innerHTML += promotionItem;
		}
		animationSlide();
	});
	
	oReq.open("GET", "./api/promotions");
	oReq.send();
}

function animationSlide()	{
    let ulPromotion = document.querySelector(".container_visual .visual_img");
	let wrapWidth = ulPromotion.clientWidth;
	let totalSlides = document.querySelectorAll(".promotion_item").length;
    
    setInterval(function()	{	
		if(slideIndex == -1)    {
	        slideIndex = totalSlides - 1;
	    }   else if(slideIndex === totalSlides)  {
	        slideIndex = 0;
	    }    
	    
	    ulPromotion.style.transform = "translate(-" + (wrapWidth * slideIndex) + "px, 0px)";
	
	    slideIndex += 1;
	}, 5000);
	
}

