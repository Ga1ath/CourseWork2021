import React from 'react';
//import Slider from 'infinite-react-carousel';
import Slider from 'react-slick';
import useStyles from './styles';
import './styles.css';

import cinema1 from '../../images/cinema1.jpg';
import cinema2 from '../../images/cinema2.jpg';
import cinema3 from '../../images/cinema3.jpg';

const settings = {
	arrows: false,
	centerMode: true,
	infinite: true,
	fade: true,
	slidesToShow: 1,
	slidesToScroll: 1,
	autoplay: true,
	speed: 2000,
	autoplaySpeed: 4000,
	cssEase: "linear"
}

const Carousel = () => {
	const classes = useStyles();

	return (
		<section className={classes.container}>
			<div className={classes.carousel}>
				<Slider {...settings}>
					<div id={1}>
						<img className={classes.image} src={cinema1} alt="first photo" />
					</div>
					<div id={2}>
						<img className={classes.image} src={cinema2} alt="second photo" />
					</div>
					<div id={3}>
						<img className={classes.image} src={cinema3} alt="third photo" />
					</div>
				</Slider>
				{/*<Slider*/}
				{/*	arrows={false}*/}
				{/*	autoplay*/}
				{/*	autoPlayInterval={3000}*/}
				{/*	centerMode*/}
				{/*	centerPadding={50}*/}
				{/*	autoplaySpeed={6000}*/}
				{/*	// shift={500}*/}
				{/*	duration={500}*/}
				{/*	pauseOnHover={false}*/}
				{/*>*/}
				{/*	<div id={1}>*/}
				{/*		<img className={classes.image} src={cinema1} alt="first photo" />*/}
				{/*	</div>*/}
				{/*	<div id={2}>*/}
				{/*		<img className={classes.image} src={cinema2} alt="second photo" />*/}
				{/*	</div>*/}
				{/*	<div id={3}>*/}
				{/*		<img className={classes.image} src={cinema3} alt="third photo" />*/}
				{/*	</div>*/}
				{/*</Slider>*/}
			</div>
		</section>
	)
};

export default Carousel;