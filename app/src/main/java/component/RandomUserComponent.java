package component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import interfaces.RandomUsersApi;
import module.PicassoModule;
import module.RandomUsersModule;


@Component(modules = {RandomUsersModule.class, PicassoModule.class})
public interface RandomUserComponent {
    RandomUsersApi getRandomUsersService();
    Picasso getPicasso();
}
