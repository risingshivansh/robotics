var A = AUI();
A.use('event', 'node-base', 'node-event-simulate', 'aui-form-validator',
		'node-event-delegate', 'aui-overlay-context-panel', 'node');

AUI().ready(function(A) {
	getData(distance, weight);
});

function getData(distance, weight) {

	var jsonString = A.JSON.stringify({'distance':distance,'weight':weight});
	
	ajaxPush(messageDiv, getResultURL, jsonString, false);

}

function ajaxPush(targetDiv, requestURL, postData, syncMode) {
	A.use('aui-io-request', function(A) {
		A.io.request(requestURL, {
			method : 'POST',
			cache : false,
			dataType : 'html',
			data : {
				postKey : postData
			},
			sync : syncMode,
			on : {
				success : function() {
					A.one(targetDiv).html(this.get('responseData'));
				}
			}
		});
	});
}
