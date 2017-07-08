<div class="modal-content">

	<div class="modal-header" style="padding: 35px 50px;">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4>Add Item</h4>
	</div>

	<div class="modal-body">
		<form action="addItem" method="post" model="item">
			<div class="input-group">
				<input id="name" type="text" required 
					name="name" placeholder="Item Name">
			</div>
			<br>
			<div class="input-group">
				<input id="name" type="text" required 
					name="desc" placeholder="Description">
			</div>
			<br>
			<div class="input-group">
				<input id="name" type="text" required 
					name="postBy" placeholder="Posted By">
			</div>
			<br>
			<div class="input-group">
				<input type="submit" class="btn btn-primary"
					value="Add item">
			</div>
		</form>
	</div>

	<div class="modal-footer">
		<button class="btn btn-danger btn-default pull-left"
			data-dismiss="modal">
			<span class="glyphicon glyphicon-remove"></span> Cancel
		</button>
	</div>


</div>