<%-- 
    Document   : updateUsernameModal
    Created on : 11-mrt-2014, 14:23:01
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="editUsernameModal" tabindex="-1" role="dialog" aria-labelledby="editUsername" aria-hidden="true">
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
                If you enter a new username now, you will need to use this to log in!
            </div>
            <div class="form-group">
                <label for="inputUser" class="col-sm-3 control-label">New username</label>
                <div class="col-sm-9">
                    <input type="text" name="username" class="form-control" id="inputUser" placeholder="username">
                </div>
            </div>
            <!--<div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>-->
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
