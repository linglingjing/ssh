	// $('#super_datatable').DataTable( {
 //    	"pagingType": "full_numbers"
	// });

/* Formatting function for row details - modify as you need */
function format ( d ) {
    // `d` is the original data object for the row
    return '<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-hover">'+
    	'<thead>'+
    		'<th>图书ID</th>'+
			'<th>图书名</th>'+
			'<th>图书原价</th>'+
			'<th>图书二手价</th>'+
			'<th>作者</th>'+
			'<th>出版社</th>'+
			'<th>数量</th>'+
		'</thead>'+
        '<tr>'+
            '<td>16</td>'+
            '<td>读懂行政管理</td>'+
            '<td>68.00</td>'+
            '<td>59.00</td>'+
            '<td>徐勇</td>'+
            '<td>清华大学出版社</td>'+
            '<td>2</td>'+
        '</tr>'+
        '<tr>'+
            '<td>1232</td>'+
            '<td>餐厅菜在家也能做</td>'+
            '<td>38.0</td>'+
            '<td>26.0</td>'+
            '<td>杨桃美食编辑部</td>'+
            '<td>清华大学出版社</td>'+
            '<td>3</td>'+
        '</tr>'+
        '<tr>'+
            '<td>16</td>'+
            '<td>读懂行政管理</td>'+
            '<td>21.6</td>'+
            '<td>45.0</td>'+
            '<td>肖文键</td>'+
            '<td>天津科学技术出版社</td>'+
            '<td>1</td>'+
        '</tr>'+
    '</table>';
}

$(document).ready(function() {
    var table = $('#order_datatable').DataTable( {
        // "ajax": "./test.txt",
        "columns": [
        	 {
                "sClass": "text-center",
                "data": "ID",
                "render": function (data, type, full, meta) {
                     return '<input type="checkbox">';
                 },
                 "bSortable": false
             },
            { "data": "orderID" },
            { "data": "userID" },
            { "data": "userName" },
            { "data": "userTel" },
            { "data": "orderTime" },
            { "data": "address" },
            { "data": "totalPrice" },
          /*  { "data": "operator" },*/
            {
                "className":      'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": '<a class="">详情</a>'
            }
        ],
        "order": [[1, 'asc']]
    } );
     
    // Add event listener for opening and closing details
    $('#order_datatable tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            // tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            // tr.addClass('shown');
        }
    } );
} );



