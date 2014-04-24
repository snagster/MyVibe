<%-- 
    Document   : removeAccountModal
    Created on : 11-mrt-2014, 17:38:16
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="removeAccountModal" tabindex="-1" role="dialog" aria-labelledby="removeAccount" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Remove your account</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" method="post">
            <div class="alert alert-danger">
                <strong>Beware!</strong>
                This action can not be undone!
            </div>
            <p>You do realize that when you remove your account, all your information will be removed.
            This action can not be undone, not even by an intervention from an admin. Are you realy sure?</p>
            
       </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <a class="btn btn-primary" role="button" href="../removemyaccount">Yes remove my account</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
