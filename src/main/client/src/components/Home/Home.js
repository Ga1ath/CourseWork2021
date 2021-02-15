import React, { useEffect } from 'react';
import useStyles from './styles';
import Posts from '../Posts/Posts';
import { useDispatch } from 'react-redux';
import { getPosts } from '../../actions/posts';
import { AppBar } from "@material-ui/core";
import Carousel from "../Carousel/Carousel";

const Home = () => {
	const dispatch = useDispatch();
	const classes = useStyles();

	// useEffect(() => {
	// 	dispatch(getPosts());
	// }, [dispatch]);

	return (
		<div className={classes.home}>
			<Carousel />
			<Posts />
		</div>
	)
}

export default Home;