import { makeStyles } from "@material-ui/core";

export default makeStyles({
	root: {
		maxWidth: 270,
	},
	media: {
		height: 190,
		overflow: "hidden",
		'& .MuiCardMedia-media': {
			transition: ".5s",
		},
		'&:hover': {
			backgroundColor: "black",
			'& .MuiCardMedia-media': {
				transform: "scale(1.5)",
			}
		},

	},

	content: {
		padding: "5px 15px"
	}
})