package com.futuretech.pdfreaderconverter.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.futuretech.pdfreaderconverter.data.dao.FileDao;
import com.futuretech.pdfreaderconverter.data.dao.FileDao_Impl;
import com.futuretech.pdfreaderconverter.data.dao.ImageQueueDao;
import com.futuretech.pdfreaderconverter.data.dao.ImageQueueDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DB_Impl extends DB {
  private volatile FileDao _fileDao;

  private volatile ImageQueueDao _imageQueueDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `FileModel` (`title` TEXT NOT NULL, `timestamp` TEXT NOT NULL, `noOfImages` INTEGER NOT NULL, `queueImage` TEXT, `isPdf` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ImageQueue` (`uriPath` TEXT, `isSelected` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7dcbf7d21d50502d0cc62ff7b0c263ff')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `FileModel`");
        _db.execSQL("DROP TABLE IF EXISTS `ImageQueue`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsFileModel = new HashMap<String, TableInfo.Column>(6);
        _columnsFileModel.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFileModel.put("timestamp", new TableInfo.Column("timestamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFileModel.put("noOfImages", new TableInfo.Column("noOfImages", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFileModel.put("queueImage", new TableInfo.Column("queueImage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFileModel.put("isPdf", new TableInfo.Column("isPdf", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFileModel.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFileModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFileModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFileModel = new TableInfo("FileModel", _columnsFileModel, _foreignKeysFileModel, _indicesFileModel);
        final TableInfo _existingFileModel = TableInfo.read(_db, "FileModel");
        if (! _infoFileModel.equals(_existingFileModel)) {
          return new RoomOpenHelper.ValidationResult(false, "FileModel(com.futuretech.pdfreaderconverter.model.FileModel).\n"
                  + " Expected:\n" + _infoFileModel + "\n"
                  + " Found:\n" + _existingFileModel);
        }
        final HashMap<String, TableInfo.Column> _columnsImageQueue = new HashMap<String, TableInfo.Column>(3);
        _columnsImageQueue.put("uriPath", new TableInfo.Column("uriPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageQueue.put("isSelected", new TableInfo.Column("isSelected", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageQueue.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysImageQueue = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesImageQueue = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoImageQueue = new TableInfo("ImageQueue", _columnsImageQueue, _foreignKeysImageQueue, _indicesImageQueue);
        final TableInfo _existingImageQueue = TableInfo.read(_db, "ImageQueue");
        if (! _infoImageQueue.equals(_existingImageQueue)) {
          return new RoomOpenHelper.ValidationResult(false, "ImageQueue(com.futuretech.pdfreaderconverter.model.ImageQueue).\n"
                  + " Expected:\n" + _infoImageQueue + "\n"
                  + " Found:\n" + _existingImageQueue);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "7dcbf7d21d50502d0cc62ff7b0c263ff", "8dabf7ca3a03b17813757c9a18a505d1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "FileModel","ImageQueue");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `FileModel`");
      _db.execSQL("DELETE FROM `ImageQueue`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(FileDao.class, FileDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ImageQueueDao.class, ImageQueueDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public FileDao getFileDao() {
    if (_fileDao != null) {
      return _fileDao;
    } else {
      synchronized(this) {
        if(_fileDao == null) {
          _fileDao = new FileDao_Impl(this);
        }
        return _fileDao;
      }
    }
  }

  @Override
  public ImageQueueDao getImageQueueDao() {
    if (_imageQueueDao != null) {
      return _imageQueueDao;
    } else {
      synchronized(this) {
        if(_imageQueueDao == null) {
          _imageQueueDao = new ImageQueueDao_Impl(this);
        }
        return _imageQueueDao;
      }
    }
  }
}
