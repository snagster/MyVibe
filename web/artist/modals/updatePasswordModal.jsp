<%-- 
    Document   : updatePasswordModal
    Created on : 11-mrt-2014, 15:39:54
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="editPasswordModal" tabindex="-1" role="dialog" aria-labelledby="editPassword" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Edit Username</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" method="post">
            <div class="alert alert-info">
                <strong>Beware!</strong>
                You do realize you are changing your password, do you?
            </div>
            <div class="form-group">
                <label for="inputUser" class="col-sm-4 control-label">Old password</label>
                <div class="col-sm-8">
                    <input type="password" name="oldPW" class="form-control" id="inputUser" placeholder="old password">
                </div>
            </div>
            <div class="form-group">
                <label for="inputUser1" class="col-sm-4 control-label">New password</label>
                <div class="col-sm-8">
                    <input type="password" name="newPW" class="form-control" id="inputUser1" placeholder="new password">
                </div>
            </div>
            <div class="form-group">
                <label for="inputUser2" class="col-sm-4 control-label">Confirm password</label>
                <div class="col-sm-8">
                    <input type="password" name="newPWconfirmed" class="form-control" id="inputUser2" placeholder="confirm password">
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
