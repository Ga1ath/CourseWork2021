import { makeStyles } from "@material-ui/core";

export default makeStyles({
	root: {
		maxWidth: "13vw",
		height: "330px",
		backgroundColor: 'ButtonFace',
		marginTop: "15px"
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
		// display: "flex",
		// alignContent: "flex-end",
		zIndex: "2"
	}
})