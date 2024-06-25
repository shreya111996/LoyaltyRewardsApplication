import { platformServer } from '@angular/platform-server';
import { AppServerModule } from './app/app.server.module';

platformServer().bootstrapModule(AppServerModule)
  .catch(err => console.error(err));
