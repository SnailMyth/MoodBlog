<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>Insert title here</title>
<c:import url="head.jsp"></c:import>
<script type="text/javascript" src="js/ckeditor.js" />

<script type="text/javascript">
	//$(document).ready(function() {

	//});
</script>
</head>
<body>
	<div>
		<%@ include file="header.jsp"%>
	</div>
	<article>
	<div class="container">
		<div class="banner">
			<p data-scroll-reveal="enter top over 2s">我们不停的翻弄着回忆，却再也找不回那时的自己</p>
			<p data-scroll-reveal="enter left over 2s after 1s">人生，是一场盛大的遇见。若你懂得，就请珍惜。</p>
			<p data-scroll-reveal="enter bottom over 2s after 2s">无论下多久的雨，最后都会有彩虹；无论你多么悲伤，要相信幸福在前方等候.</p>
		</div>
		<div class="container"
			style="margin-left: 0px; margin-right: 0px; background: #fff; padding: 0px; color: #333;">
			<div class="container"
				style="padding-left: 0px; padding-right: 0px; margin: 10px;">
				<div class="row"
					style="display: inherit; margin-left: 0px; margin-right: 0px">
					<font size="5px" color="black"><b style="margin-left: 30px;">Editor
							your mind</b></font>
					<div>
						<div class="ck-editor">
							<!-- The toolbar of the editor. -->
							<div class="btn-toolbar" role="toolbar"
								aria-label="Editor toolbar">
								<!-- The headings drop-down. -->
								<div class="btn-group mr-2" role="group" aria-label="Headings">
									<div class="dropdown" id="heading">
										<button class="btn btn-primary btn-sm dropdown-toggle"
											type="button" data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<span>Headings</span>
										</button>
										<div class="dropdown-menu" aria-labelledby="heading-button"></div>
									</div>
								</div>

								<!-- Basic styles buttons. -->
								<div class="btn-group mr-2" role="group"
									aria-label="Basic styles">
									<button type="button" class="btn btn-primary btn-sm" id="bold">B</button>
									<button type="button" class="btn btn-primary btn-sm"
										id="italic">I</button>
									<button type="button" class="btn btn-primary btn-sm"
										id="underline">U</button>
								</div>

								<!-- Undo and redo buttons. -->
								<div class="btn-group mr-2" role="group" aria-label="Undo">
									<button type="button" class="btn btn-primary btn-sm" id="undo">&larr;</button>
									<button type="button" class="btn btn-primary btn-sm" id="redo">&rarr;</button>
								</div>
							</div>

							<!-- The container with the data of the editor. -->
							<div id="editor">
								<p>Hello world!</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</article>
	<div>
		<%@ include file="footer.jsp"%>
	</div>
<script type="text/javascript">
const command = editor.commands.get( 'undo' );

command.on( 'change:isEnabled', ( evt, name, isEnabled ) => {
    if ( isEnabled ) {
        console.log( 'Whoa, you can undo some stuff now.' );
    } else {
        console.log( 'There is nothing to undo in the editor.' );
    }
} );
function setupButtons( editor ) {
    [ 'bold', 'italic', 'underline', 'undo', 'redo' ].forEach( commandName => {
        // Retrieve the editor command corresponding with the ID of the button in DOM.
        const command = editor.commands.get( commandName );

        // Retrieve the jQuery object corresponding with the button in DOM.
        const button = $( `#${ commandName }` );

        // Clicking the buttons should execute the editor command...
        button.click( () => editor.execute( commandName ) );

        // ...but it should not steal the focus so the editing is uninterrupted.
        button.mousedown( evt => evt.preventDefault() );

        // Commands can become disabled, e.g. when the editor is read-only.
        // Make sure the buttons reflect this state change.
        command.on( 'change:isEnabled', onIsEnabledChange );
        onIsEnabledChange();

        // Bold, Italic and Underline commands have a value that changes
        // when the selection starts in an element that the command creates.
        // The button should indicate that the user is editing a text which
        // is already bold.
        if ( !new Set( [ 'undo', 'redo' ] ).has( commandName ) ) {
            command.on( 'change:value', onValueChange );
            onValueChange();
        }

        function onValueChange() {
            button.toggleClass( 'active', command.value );
        }

        function onIsEnabledChange() {
            button.attr( 'disabled', () => !command.isEnabled );
        }
    } );
}

function setupHeadingDropdown( editor ) {
    const menu = $( '.ck-editor .dropdown-menu' );
    const button = $( '.ck-editor .dropdown-toggle' );

    // Create a drop-down menu entry for each heading configuration option.
    editor.config.get( 'heading.options' ).map( option => {
        // Retrieve the editor command corresponding with the configuration option.
        const command = editor.commands.get( option.modelElement );
        // Create the menu item DOM element.

        const menuItem = $(
            `<a href="#" class="dropdown-item heading-item_${ option.modelElement }">` +
                `${ option.title }` +
            '</a>' );

        // Upon clicking, the drop-down menu item should execute the command and focus
        // the editing view to keep the editing process uninterrupted.
        menuItem.click( () => {
            editor.execute( option.modelElement );
            editor.editing.view.focus();
        } );

        menu.append( menuItem );

        // Make sure the drop-down and its items reflect the state of the
        // currently active command.
        command.on( 'change:value', onValueChange );
        onValueChange();

        // Heading commands can become disabled, e.g. when the editor is read-only.
        // Make sure the UI reflects this state change.
        command.on( 'change:isEnabled', onIsEnabledChange );
        onIsEnabledChange();

        function onValueChange() {
            if ( command.value ) {
                button.children( ':first' ).text( option.title );
            }

            menuItem.toggleClass( 'active', command.value );
        }

        function onIsEnabledChange() {
            button.attr( 'disabled', () => !command.isEnabled );
        }
    } );
}

setupButtons( editor );
setupHeadingDropdown( editor );


BootstrapEditor
.create( $( '#editor' ).get( 0 ), {
    plugins: [
        Clipboard, Enter, Typing, Paragraph,
        BoldEngine, ItalicEngine, UnderlineEngine, HeadingEngine, UndoEngine
    ]
} )
.then( editor => {
    window.editor = editor;
} )
.catch( err => {
    console.error( err.stack );
} );
</script>

	<style type="text/css">
.content_word {
	padding-right: 15px;
}

.title {
	margin-top: 50px;
}

/* Give the editor some space and limits using a border. */
.ck-editor {
	margin: 1em 0;
	border: 1px solid rgba(0, 0, 0, .1);
	border-radius: 4px;
}

/* Adding internal spacing, border and background to the toolbar.  */
.ck-editor .btn-toolbar {
	padding: .5rem;
	background: #f7f7f9;
	border-bottom: 1px solid rgba(0, 0, 0, .1);
}

/* Tweaking the editable area for better readability. */
.ck-editor .ck-editor__editable {
	padding: 2em 2em 1em;
	overflow: auto;
}

/* When in read–only mode, the editable should fade out. */
.ck-editor .ck-editor__editable:not ([contenteditable] ) {
	background: #fafafa;
	color: #777;
}

/* Make sure the headings drop-down button does not change its size
as different headings are selected. */
.ck-editor .dropdown-toggle span {
	display: inline-block;
	width: 100px;
	text-align: left;
	overflow: hidden;
	text-overflow: ellipsis;
	vertical-align: bottom;
}

/* Make the headings drop-down items visually distinctive. */
.ck-editor .heading-item_heading1 {
	font-size: 1.5em;
}

.ck-editor .heading-item_heading2 {
	font-size: 1.3em;
}

.ck-editor .heading-item_heading3 {
	font-size: 1.1em;
}

.ck-editor [class*="heading-item_"] {
	line-height: 22px;
	padding: 10px;
}

.ck-editor [class*="heading-item_heading"] {
	font-weight: bold;
}

/* Give the basic styles buttons the icon–like look and feel. */
.ck-editor #bold {
	font-weight: bold;
}

.ck-editor #italic {
	font-style: italic;
}

.ck-editor #underline {
	text-decoration: underline;
}
</style>
</body>
</html>
