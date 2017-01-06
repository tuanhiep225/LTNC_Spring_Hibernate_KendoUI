var sanpham=[];
var mausac=[];
var kichthuoc=[];
var dataSourceSanPham= new kendo.data.DataSource({
	transport: {
        read: {
        	url: "/LTNC/api/product/getall",
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
var dataSourceMauSac= new kendo.data.DataSource({
	transport: {
        read: {
        	url: "/LTNC/api/product-color/getall",
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
var dataSourceKichThuoc= new kendo.data.DataSource({
	transport: {
        read: {
        	url: "/LTNC/api/product-size/getall",
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
$(document).ready(function(){
	dataSourceSanPham.fetch(function(){
		var data=this.data();
		for (var i = 0; i < data.length; i++) {
			sanpham.push({
				value: data[i].productId,
                text: data[i].productName
			})
		};
		dataSourceMauSac.fetch(function(){
			var data=this.data();
			for (var i = 0; i < data.length; i++) {
				mausac.push({
					value: data[i].productColorId,
	                text: data[i].productColorName
				})
			};
			dataSourceKichThuoc.fetch(function(){
				var data=this.data();
				for (var i = 0; i < data.length; i++) {
					kichthuoc.push({
						value: data[i].productSizeId,
		                text: data[i].productSizeName
					})
				};
				
				var dataSource = new kendo.data.DataSource({
					transport: {
			            read: {
			                url: "/LTNC/api/product-store/getall",
			                type: "get",
			                dataType: 'json'
			            },
			            create: {
			                url: "/LTNC/api/product-store/create",
			                type: "post",
			                dataType: 'json',
			                contentType: "application/json"
			            },
			            update: {
			                url: "/LTNC/api/product-store/update",
			                type: 'post',
			                dataType: 'json',
			                contentType: "application/json"
			            },
			            destroy: {
			                url: "/LTNC/api/product-store/delete",
			                type: 'post',
			                dataType: "json",
			                contentType: "application/json"
			            },
			            parameterMap: function (data, type) {
			                if (type !== "read") {
			                    if (type === "create") {
			                    	var arr={
			                    			productId:data.models[0].productId,
			                    			productColorId:data.models[0].productColorId,
			                    			productSizeId:data.models[0].productSizeId,
			                    			purchasePrice:data.models[0].purchasePrice,
			                    			dayTrading:data.models[0].dayTrading,
			                    			price:data.models[0].price,
			                    			quantity:data.models[0].quantity,
			                    			note:data.models[0].note,
			                    			sale:data.models[0].sale,
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
			                id: "productStoreId",
			                fields: {
			                	productStoreId: { type: "number" },
			                	productId:{type:"number"},
			                	productColorId:{type:"number"},
			                	productSizeId: { type: "number" },
			                	purchasePrice: { type: "number" },
			                	dayTrading: { type: "date" },
			                	price:{type:"number"},
			                	quantity:{type:"number"},
			                	note: { type: "string" },
			                	sale:{type:"number"}
			                }
			            }
			        }
				});
				var grid = $("#grid-product-store").kendoGrid({
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
				        	{ command: [{ name: "destroy", text: "Xóa" },{ name: "edit", text: "Sửa" }], title: "Thao Tác", width: 250 },
				        	{
			                    field: "productId", title: "Tên Sản Phẩm", width: 175,values:sanpham
			                },
			                {
			                    field: "productColorId", title: "Màu Săc", width: 175,values:mausac
			                },
			                {
			                    field: "productSizeId", title: "Kích Thước", width: 175,values:kichthuoc
			                },
			                {
			                    field: "quantity", title: "Số Lượng", width: 175
			                },
			                {
			                    field: "price", title: "Giá Bán", width: 175
			                },
			                {
			                    field: "purchasePrice", title: "Giá Nhập", width: 175
			                },
			                
			                {
			                    field: "sale", title: "Sale", width: 175
			                },
			                {
			                    field: "dayTrading", title: "Ngày Nhập", width: 175,format: "{0:dd/MM/yyyy}",
			                },
			                {
			                    field: "note", title: "Ghi Chú", width: 175
			                }
				        ],
				        editable: {
				            confirmation: "Bạn có chắc chắn muốn xóa bản ghi này ?",
				            confirmDelete: "Yes",
				            mode:"popup"
				        }
				});
				
				
				
			});
		});
	});
});