$(document).ready(function () {
    var dataSource = new kendo.data.DataSource({
        transport: {
            read: {
                url: "/LTNC/api/brand/getall",
                type: "get",
                dataType: 'json'
            },
            create: {
                url: "/LTNC/api/brand/create",
                type: "post",
                dataType: 'json',
                contentType: "application/json"
            },
            update: {
                url: "/LTNC/api/brand/update",
                type: 'post',
                dataType: 'json',
                contentType: "application/json"
            },
            destroy: {
                url: "/LTNC/api/brand/delete",
                type: 'post',
                dataType: "json",
                contentType: "application/json"
            },
            parameterMap: function (data, type) {
                if (type !== "read") {
                    if (type === "create") {
                    	var arr={
                    			brandName:data.models[0].brandName,
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
                id: "brandId",
                fields: {
                	brandId: { type: "number" },
                	brandName: { type: "string" }
                }
            }
        }
    });
    var grid = $("#grid-brand").kendoGrid({
        dataSource: dataSource,
        height: window.innerHeight * 0.8,
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
            mode: "row",
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
                { command: [{ name: "destroy", text: "Xóa" },{ name: "edit", text: "Sửa" }], title: "Thao Tác", width: 120 },
                {
                    field: "brandName", title: "Tên Thương Hiệu", width: 400,
                }
        ],
        editable: {
            confirmation: "Bạn có chắc chắn muốn xóa bản ghi này ?",
            confirmDelete: "Yes",
            mode:"inline"
        }
    });
});