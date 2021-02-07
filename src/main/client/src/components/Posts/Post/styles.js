import { makeStyles } from "@material-ui/core";

export default makeStyles({
	root: {
		maxWidth: 270,
	},
	media: {
		height: 190,
		overflow: "hidden",
		'& .image': {
			transition: ".5s",
		},
		'&:hover': {
			'& .image': {
				transform: "scale(1.5)",
			}
		}
	},

	content: {
		padding: "5px 15px"
	}
})