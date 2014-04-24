<%-- 
    Document   : updateUserFullnameModal
    Created on : 11-mrt-2014, 15:39:03
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="editUserFullnameModal" tabindex="-1" role="dialog" aria-labelledby="editFullname" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Edit your Artistname</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" method="post">
            <div class="form-group">
                <label for="inputName" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="inputName" placeholder="name">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-9 col-sm-1">
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
