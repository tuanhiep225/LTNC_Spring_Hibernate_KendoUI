var danhmuc=[];
var nhanhieu=[];
var dataSourceDanhMuc= new kendo.data.DataSource({
	transport: {
        read: {
        	url: "/LTNC/api/category/getall",
            type: "get",
            dataType: 'json'
        }
    },
    schema: {
        type: 'json',
        data: function (response) {
            return response.data;
        }
    }
});
var dataSourceNhanHieu=new kendo.data.DataSource({
	transport: {
        read: {
        	url: "/LTNC/api/brand/getall",
            type: "get",
            dataType: 'json'
        }
    },
    schema: {
        type: 'json',
        data: function (response) {
            return response.data;
        }
    }
});
$(document).ready(function () {
	dataSourceDanhMuc.fetch(function(){
		var data=this.data();
		for (var i = 0; i < data.length; i++) {
			danhmuc.push({
				value: data[i].categoryId,
                text: data[i].categoryName
			})
		};
		dataSourceNhanHieu.fetch(function(){
			var data1=this.data();
			for (var i = 0; i < data1.length; i++) {
				nhanhieu.push({
					value: data1[i].brandId,
	                text: data1[i].brandName
				})
			};
			var dataSource = new kendo.data.DataSource({
		        transport: {
		            read: {
		                url: "/LTNC/api/product/getall",
		                type: "get",
		                dataType: 'json'
		            },
		            create: {
		                url: "/LTNC/api/product/create",
		                type: "post",
		                dataType: 'json',
		                contentType: "application/json"
		            },
		            update: {
		                url: "/LTNC/api/product/update",
		                type: 'post',
		                dataType: 'json',
		                contentType: "application/json"
		            },
		            destroy: {
		                url: "/LTNC/api/product/delete",
		                type: 'post',
		                dataType: "json",
		                contentType: "application/json"
		            },
		            parameterMap: function (data, type) {
		                if (type !== "read") {
		                    if (type === "create") {
		                    	var arr={
		                    			brandId:data.models[0].brandId,
		                    			categoryId:data.models[0].categoryId,
		                    			productImage:data.models[0].productImage,
		                    			productName:data.models[0].productName,
		                    			isActive:true
		                    	}
		                        return  kendo.stringify(arr)
		                    }
		                    return kendo.stringify(data.models[0])
		                }
		            }
		        },
		        batch: true,
		        pageSize: 20,
		        schema: {
		            type: 'json',
		            data: 'data',
		            total: "itemCount",
		            model: {
		                id: "productId",
		                fields: {
		                	productId: { type: "number" },
		                	brandId:{type:"number"},
		                	categoryId:{type:"number"},
		                	productImage: { type: "string" },
		                	productName: { type: "string" },
		                }
		            }
		        }
		    });
		    var grid = $("#grid-product").kendoGrid({
		        dataSource: dataSource,
		        height: window.innerHeight * 0.9,
		        sortable: true,
		        columnMenu: {
		            messages: {
		                columns: "Chọn cột",
		                filter: "Lọc",
		                sortAscending: "Tăng dần",
		                sortDescending: "Giảm dần",
		            }
		        },
		        pageable: {
		            pageSize: 50,
		            pageSizes: true,
		            refresh: true,
		            messages: {
		                display: "{0} - {1} của {2} kết quả",
		                empty: "Không có kết quả nào",
		                page: "trang",
		                of: "của {0}",
		                itemsPerPage: "kết quả/trang",
		                first: "Về trang đầu",
		                previous: "Về trang trước",
		                next: "Về trang tiếp theo",
		                last: "Về trang cuối",
		                refresh: "Làm mới",
		                allPages: "Tất"
		            }
		        },
		        filterable: {
		            messages: {
		                and: "và",
		                or: "hoặc"
		            },
		            operators: {
		                string: {
		                    contains: "Chứa từ khóa",
		                    doesnotcontain: "Không chứa từ khóa này",
		                    endswith: "Kết thúc với từ khóa này",
		                    eq: "So sánh bằng",
		                    isempty: "Từ khóa rỗng",
		                    isnotempty: "Không trống",
		                    neq: "Không bằng",
		                    startswith: "Bắt đầu với từ khóa này"
		                }

		            }
		        },
		        resizable: true,
		        toolbar: [{ name: "create", text: "Thêm Mới" }, { name: "excel", text: "Xuất Excel" }],
		        columns: [
		                { command: [{ name: "destroy", text: "Xóa" },{ name: "edit", text: "Sửa" },{
		                    name: "Nhập Hàng",
		                    click: nhaphang,
		                    className:"btn-grid-nhaphang"
		                    }], title: "Thao Tác", width: 250 },
		                {
		                    field: "productName", title: "Tên Sản Phẩm", width: 200,
		                },
		                {
		                    field: "categoryId", title: "Danh Mục", width: 175,values:danhmuc
		                },
		                {
		                    field: "brandId", title: "Nhãn Hiệu", width: 175,values:nhanhieu
		                },
		                {
		                	field: "productImage", title: "Ảnh", width: 175,
		                	 template: "<div class='customer-photo'" +
		                     "style='background-image: url(/LTNC/resources/images/upload/#:data.productImage#);'></div>"
		                }
		        ],
		        editable: {
		            confirmation: "Bạn có chắc chắn muốn xóa bản ghi này ?",
		            confirmDelete: "Yes",
		            mode:"popup"
		        }
		    });
		    function nhaphang(e){
		    	e.preventDefault();
		    	var tr = $(e.target).closest("tr");
		    	var data = this.dataItem(tr);
		    	var color;
		    	var size;
		    	 wnd = $("#nhaphang")
                 .kendoWindow({
                     title: "Nhập Hàng",
                     modal: true,
                     visible: false,
                     resizable: false
                 }).data("kendoWindow");
		    	 wnd.content(kendo.template($("#template").html()));
		    	 wnd.center().open();
		    	 
		    	 $("#productCorlor").kendoDropDownList({
                     dataTextField: "productColorName",
                     dataValueField: "productColorId",
                     dataSource: {
                         transport: {
                             read: {
                                 url: "/LTNC/api/product-color/getall",
                                 type: 'get',
                                 dataType: 'json'
                             }
                         },
                         schema: {
                             type: 'json',
                             data: function (response) {
                                 return response.data;
                             }
                         }
                     },
                     select: function (e) {
                    	 color = e.dataItem.productColorId;
                     }
                 });
		    	 
		    	 $("#productSize").kendoDropDownList({
                     dataTextField: "productSizeName",
                     dataValueField: "productSizeId",
                     dataSource: {
                         transport: {
                             read: {
                                 url: "/LTNC/api/product-size/getall",
                                 type: 'get',
                                 dataType: 'json'
                             }
                         },
                         schema: {
                             type: 'json',
                             data: function (response) {
                                 return response.data;
                             }
                         }
                     },
                     select: function (e) {
                    	 size = e.dataItem.productSizeId;
                     }
                 });
		    	 
		    	 $("#productNgayNhap").kendoDatePicker({
                     format: "dd/MM/yyyy",
                     value: new Date()
                 });
		    	 $("#productQuantity").kendoNumericTextBox({
		    		 min: 0,
	                 max: 1000,
	                 value: 1,
	                 format:"#"
		    	 });
		    	 $("#productGiaNhap").kendoNumericTextBox({
		    		 min: 0
		    	 });
				$("#productGiaBan").kendoNumericTextBox({
					min: 0  		 
				});
				$("#productSale").kendoNumericTextBox({
					format: "p0",
                    min: 0,
                    max: 1,
                    step: 0.01
				});
		    	 $("#cancelDatHang").click(function () {
                     wnd.close();
                 });
		    	 $("#updateDatHang").click(function(){
		    		 var model={
		    				 productId:data.productId,
		    				 productColorId:$("#productCorlor").data("kendoDropDownList").value(),
		    				 productSizeId:$("#productSize").data("kendoDropDownList").value(),
		    				 quantity:$("#productQuantity").val(),
		    				 purchasePrice:$("#productGiaNhap").val(),
		    				 price:$("#productGiaBan").val(),
		    				 sale:$("#productSale").val(),
		    				 note:$("#productGhiChu").val(),
		    				 dayTrading:kendo.toString($("#productNgayNhap").data("kendoDatePicker").value(), 'yyyy-MM-dd HH:mm:ss'),
		    				 isActive:true
		    				 
		    		 };
		    		 
		    		 var soluong=$("#productQuantity").val();
		    		 debugger
		    		 if(soluong !=="")
		    			 {
			    			 $.ajax({
					    			url: "/LTNC/api/product-store/create",
			                        dataType: 'json',
			                        type: 'post',
			                        data: kendo.stringify(model),
			                        success: function (result) {
			                            if (result.status === 1) {
			                                wnd.close();
			                            }
			                        }
					    		}); 
		    			 }
		    		 else
	    			 {
	    			 	$(".k-tooltip-validation").css({"display":"block"});
	    			 	$("#productQuantity").keyup(function () {
	    			 		if($("#productQuantity").val()!=="")
	    			 			{
	    			 				$(".k-tooltip-validation").css({"display":"none"});
	    			 			}
	                    });
	    			 }
	    		
		    	 });
		    }
		   
		});
	});
	
});