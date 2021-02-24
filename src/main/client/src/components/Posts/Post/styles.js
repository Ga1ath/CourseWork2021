import { makeStyles } from "@material-ui/core";

export default makeStyles({
	root: {
		maxWidth: 270,
		backgroundColor: 'ButtonFace',
		marginTop: "30px"
	},
	media: {
		height: 190,
		transition: ".25s",
		'&:hover': {
			transform: "scale(1.25)"
		},
	},
	mediaContainer: {
		overflow: "hidden"
	},

	content: {
		padding: "5px 15px",
		zIndex: "2"
	}
})