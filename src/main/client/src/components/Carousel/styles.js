import { fade, makeStyles } from '@material-ui/core';


export default makeStyles((theme) => ({
	container: {
		margin: "0 13px",
		height: "100%",
		[theme.breakpoints.down('sm')]: {
			display: "none",
		}
	},
	carousel: {
		paddingTop: "63px",
		marginLeft: "auto",
		marginRight: "auto",
		width: "50%",
	},
	image: {
		//width: "100%",
		maxWidth: "400px",
		//height: "87vh"
	},
	imageContainer: {
		display: "flex",
		justifyContent: "center",
		flexDirection: "row"
}
}));